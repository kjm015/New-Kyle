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
import io.github.kjm015.newkyle.util.computer.motherboard.MotherboardRepository
import io.github.kjm015.newkyle.util.computer.psu.PowerSupply
import io.github.kjm015.newkyle.util.computer.psu.PowerSupplyRepository
import io.github.kjm015.newkyle.util.computer.storage.StorageRepository
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
    fun buildComputer(budget: Double = 900.00, requester: String = "Someone"): Computer {
        val cpuBudget = budget * 0.20
        val gpuBudget = budget * 0.37
        val mobBudget = budget * 0.13
        val ramBudget = budget * 0.08
        val casBudget = budget * 0.10
        val psuBudget = budget * 0.08
        val stoBudget = budget * 0.07

        var cpu = findBestCPU(cpuBudget)
        val mob = findBestMotherboard(cpu, mobBudget)
        val ram = findBestRAM(mob, ramBudget)
        var gpu = findBestGPU(gpuBudget)
        val case = findBestCase(mob, gpu, casBudget)
        val psu = findBestPSU(case, psuBudget)

        val storage =
            arrayListOf(storageRepository.findAll().filter { it.price <= stoBudget }.maxByOrNull { it.price }!!)

        var cost = cpu.price + mob.price + gpu.price + ram.price + case.price + psu.price + storage.first().price
        var remainingBudget = budget - cost

        val cooler = findBestCooler(mob, case, cpu, remainingBudget)

        remainingBudget -= cooler.price
        cost += cooler.price

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
            price = cost
        )
    }

    private fun findBestCPU(budget: Double): CPU {
        return cpuRepository.findAll().filter {
            it.price <= budget
        }.maxByOrNull { it.price }!!
    }

    private fun findBestMotherboard(cpu: CPU, budget: Double): Motherboard {
        return motherboardRepository.findAll().filter {
            it.socket == cpu.socket && it.price <= budget
        }.maxByOrNull { it.price }!!
    }

    private fun findBestRAM(motherboard: Motherboard, budget: Double): MemoryKit {
        return memoryRepository.findAll().filter {
            it.price <= budget && it.moduleCount * it.moduleCapacityGB < motherboard.maxMemoryLimitGB && it.speed <= motherboard.maxMemorySpeed
        }.maxByOrNull { it.price }!!
    }

    private fun findBestGPU(budget: Double): GraphicsCard {
        return gpuRepository.findAll().filter {
            it.price <= budget
        }.maxByOrNull { it.price }!!
    }

    private fun findBestCase(motherboard: Motherboard, gpu: GraphicsCard, budget: Double): ComputerCase {
        return caseRepository.findAll().filter {
            it.price <= budget && it.formFactor == motherboard.formFactor && it.maxGPULength >= gpu.length
        }.maxByOrNull { it.price }!!
    }

    private fun findBestPSU(case: ComputerCase, budget: Double): PowerSupply {
        return powerSupplyRepository.findAll().filter {
            it.price <= budget && it.formFactor == case.psuFormFactor
        }.maxByOrNull { it.price }!!
    }

    private fun findBestCooler(motherboard: Motherboard, case: ComputerCase, cpu: CPU, budget: Double): CPUCooler {
        return coolerRepository.findAll().filter {
            it.price <= budget / 1.5 && it.supportedSockets.contains(motherboard.socket) && (it.radiatorSize <= case.maxRadiatorSupport)
        }.maxByOrNull {
            it.price
        } ?: if (cpu.includedCoolerName != null)
            coolerRepository.findByName(cpu.includedCoolerName)
        else
            CPUCooler(
                id = -1L,
                name = "",
                manufacturer = "",
                isLiquidCooler = false,
                radiatorSize = 0,
                fanSize = 0,
                fanCount = 0,
                hasRGB = false,
                height = 0,
                supportedSockets = arrayListOf(),
                price = 0.00
            )
    }
}