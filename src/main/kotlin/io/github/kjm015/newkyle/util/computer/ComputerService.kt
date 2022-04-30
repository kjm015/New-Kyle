package io.github.kjm015.newkyle.util.computer

import io.github.kjm015.newkyle.util.computer.compcase.CaseRepository
import io.github.kjm015.newkyle.util.computer.compcase.ComputerCase
import io.github.kjm015.newkyle.util.computer.cooler.CPUCooler
import io.github.kjm015.newkyle.util.computer.cooler.CoolerRepository
import io.github.kjm015.newkyle.util.computer.cpu.CPU
import io.github.kjm015.newkyle.util.computer.cpu.CPURepository
import io.github.kjm015.newkyle.util.computer.gpu.GPURepository
import io.github.kjm015.newkyle.util.computer.gpu.GraphicsCard
import io.github.kjm015.newkyle.util.computer.memory.MemoryKit
import io.github.kjm015.newkyle.util.computer.memory.MemoryRepository
import io.github.kjm015.newkyle.util.computer.motherboard.Motherboard
import io.github.kjm015.newkyle.util.computer.motherboard.MotherboardFormFactor
import io.github.kjm015.newkyle.util.computer.motherboard.MotherboardRepository
import io.github.kjm015.newkyle.util.computer.psu.PowerSupply
import io.github.kjm015.newkyle.util.computer.psu.PowerSupplyFormFactor
import io.github.kjm015.newkyle.util.computer.psu.PowerSupplyRepository
import io.github.kjm015.newkyle.util.computer.storage.Storage
import io.github.kjm015.newkyle.util.computer.storage.StorageRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ComputerService(
    private val caseRepository: CaseRepository,
    private val coolerRepository: CoolerRepository,
    private val cpuRepository: CPURepository,
    private val gpuRepository: GPURepository,
    private val memoryRepository: MemoryRepository,
    private val motherboardRepository: MotherboardRepository,
    private val powerSupplyRepository: PowerSupplyRepository,
    private val storageRepository: StorageRepository
) {
  val log: Logger = LoggerFactory.getLogger(this.javaClass)

  var cpuBudget = 0.00
  var gpuBudget = 0.00
  var mobBudget = 0.00
  var ramBudget = 0.00
  var casBudget = 0.00
  var psuBudget = 0.00
  var stoBudget = 0.00

  fun buildComputer(budget: Double = 900.00, requester: String = "Someone"): Computer {
    determineBudgetDistribution(budget)

    val cpu = findBestCPU(cpuBudget)
    val mob = findBestMotherboard(cpu, mobBudget)
    val ram = findBestRAM(mob, ramBudget)
    var gpu = findBestGPU(gpuBudget, cpu)
    val case = findBestCase(mob, gpu, casBudget)
    val psu = findBestPSU(case, psuBudget)

    val storage = arrayListOf(findBestStorageForBudget(stoBudget))

    var cost =
        cpu.price +
            mob.price +
            gpu.price +
            ram.price +
            case.price +
            psu.price +
            storage.first().price
    var remainingBudget = budget - cost

    if (remainingBudget < 0) remainingBudget = 1.0

    var cooler = findBestCooler(mob, case, cpu, remainingBudget)
    remainingBudget -= cooler.price

    log.info("Computer Service - Budget set as $budget, with $remainingBudget remaining.")

    if (remainingBudget > 50) {
      val sto = findBestStorageForBudget(remainingBudget)
      storage.add(sto)
      cost += sto.price
      remainingBudget -= sto.price

      if (remainingBudget >= 50) {
        val oldPrice = gpu.price
        gpu = findBestGPU(remainingBudget + oldPrice, cpu)
        cost += gpu.price - oldPrice
        remainingBudget -= gpu.price - oldPrice
      }
    } else if (remainingBudget > 1) {
      val newPrice = remainingBudget + cooler.price
      log.info("Computer Service - Attempting to find a new cooler with budget of $newPrice")
      cooler = findBestCooler(mob, case, cpu, newPrice)
      cost += cooler.price
    }

    return Computer(
        cpu = cpu,
        gpu = gpu,
        motherboard = mob,
        memory = ram,
        case = case,
        powerSupply = psu,
        cooler = cooler,
        name = "${requester}'s PC",
        owner = requester,
        storage = storage,
        price = cost)
  }

  private fun findBestCPU(budget: Double): CPU {
    return cpuRepository.findAll().filter { it.price <= budget }.maxByOrNull { it.price }
        ?: findCheapestCPU()
  }

  private fun findBestMotherboard(cpu: CPU, budget: Double): Motherboard {
    return motherboardRepository
        .findAll()
        .filter { it.socket == cpu.socket && it.price <= budget }
        .maxByOrNull { it.price }
        ?: findCheapestMotherboardForCPU(cpu)
  }

  private fun findBestRAM(motherboard: Motherboard, budget: Double): MemoryKit {
    return memoryRepository
        .findAll()
        .filter {
          it.price <= budget &&
              it.moduleCount <= motherboard.memorySlots &&
              it.memoryGeneration == motherboard.memoryType
        }
        .maxByOrNull { it.price }
        ?: findCheapestRAMForBoard(motherboard)
  }

  private fun findBestGPU(budget: Double, cpu: CPU): GraphicsCard {
    return gpuRepository.findAll().filter { it.price <= budget }.maxByOrNull { it.price }
        ?: findCheapestGPU(cpu)
  }

  private fun findBestCase(
      motherboard: Motherboard,
      gpu: GraphicsCard,
      budget: Double
  ): ComputerCase {
    return caseRepository
        .findAll()
        .filter {
          it.price <= budget &&
              it.formFactor.toString().contains(motherboard.formFactor.toString()) &&
              it.maxGPULength >= gpu.length
        }
        .maxByOrNull { it.price }
        ?: findCheapestCaseForFormFactor(motherboard.formFactor)
  }

  private fun findBestPSU(case: ComputerCase, budget: Double): PowerSupply {
    return powerSupplyRepository
        .findAll()
        .filter { it.price <= budget && it.formFactor == case.psuFormFactor }
        .maxByOrNull { it.price }
        ?: findCheapestPSUForFormFactor(case.psuFormFactor)
  }

  private fun findBestCooler(
      motherboard: Motherboard,
      case: ComputerCase,
      cpu: CPU,
      budget: Double
  ): CPUCooler {
    return coolerRepository
        .findAll()
        .filter {
          it.price > 1 &&
              it.price <= budget &&
              it.supportedSockets.contains(motherboard.socket) &&
              (it.radiatorSize <= case.maxRadiatorSupport)
        }
        .maxByOrNull { it.price }
        ?: if (cpu.includedCoolerName != null) coolerRepository.findByName(cpu.includedCoolerName)
        else coolerRepository.findAllByPriceGreaterThan(1.0).first()
  }

  private fun findBestStorageForBudget(budget: Double): Storage {
    return storageRepository.findAll().filter { it.price <= budget }.maxByOrNull { it.price }
        ?: findCheapestStorage()
  }

  private fun findCheapestCPU(): CPU = cpuRepository.findAll().minByOrNull { it.price }!!

  private fun findCheapestMotherboardForCPU(cpu: CPU): Motherboard =
      motherboardRepository.findAllBySocket(cpu.socket).minByOrNull { it.price }!!

  private fun findCheapestRAMForBoard(motherboard: Motherboard): MemoryKit {
    return memoryRepository.findAllByMemoryGeneration(motherboard.memoryType).minByOrNull {
      it.price
    }!!
  }

  private fun findCheapestCaseForFormFactor(formFactor: MotherboardFormFactor): ComputerCase {
    return caseRepository.findAllByFormFactor(formFactor).minByOrNull { it.price }!!
  }

  private fun findCheapestGPU(cpu: CPU): GraphicsCard {
    return if (cpu.integratedGraphics != null)
        GraphicsCard(manufacturer = cpu.company, productName = cpu.integratedGraphics, price = 0.00)
    else gpuRepository.findAll().minByOrNull { it.price }!!
  }

  private fun findCheapestPSUForFormFactor(formFactor: PowerSupplyFormFactor): PowerSupply {
    return powerSupplyRepository.findAllByFormFactor(formFactor).minByOrNull { it.price }!!
  }

  private fun findCheapestStorage(): Storage {
    return storageRepository.findAll().minByOrNull { it.price }!!
  }

  private fun determineBudgetDistribution(budget: Double) {
    if (budget < 900) {
      cpuBudget = budget * 0.20
      gpuBudget = budget * 0.32
      mobBudget = budget * 0.15
      ramBudget = budget * 0.10
      casBudget = budget * 0.10
      psuBudget = budget * 0.07
      stoBudget = budget * 0.07
    } else if (budget in 900.0..3000.0) {
      cpuBudget = budget * 0.17
      gpuBudget = budget * 0.39
      mobBudget = budget * 0.12
      ramBudget = budget * 0.09
      casBudget = budget * 0.10
      psuBudget = budget * 0.07
      stoBudget = budget * 0.07
    } else if (budget in 3000.0..7000.0) {
      cpuBudget = budget * 0.18
      gpuBudget = budget * 0.40
      mobBudget = budget * 0.11
      ramBudget = budget * 0.10
      casBudget = budget * 0.09
      psuBudget = budget * 0.07
      stoBudget = budget * 0.09
    } else {
      cpuBudget = budget * 0.30
      gpuBudget = budget * 0.30
      mobBudget = budget * 0.09
      ramBudget = budget * 0.10
      casBudget = budget * 0.09
      psuBudget = budget * 0.07
      stoBudget = budget * 0.09
    }
  }
}
