package io.github.kjm015.kylenewer.util.computer

import io.github.kjm015.kylenewer.util.computer.compcase.CaseRepository
import io.github.kjm015.kylenewer.util.computer.cooler.CPUCooler
import io.github.kjm015.kylenewer.util.computer.cooler.CoolerRepository
import io.github.kjm015.kylenewer.util.computer.cpu.CPURepository
import io.github.kjm015.kylenewer.util.computer.gpu.GPURepository
import io.github.kjm015.kylenewer.util.computer.gpu.GraphicsCard
import io.github.kjm015.kylenewer.util.computer.memory.MemoryRepository
import io.github.kjm015.kylenewer.util.computer.motherboard.MotherboardRepository
import io.github.kjm015.kylenewer.util.computer.psu.PowerSupplyRepository
import io.github.kjm015.kylenewer.util.computer.storage.StorageRepository
import org.springframework.stereotype.Service
import javax.validation.constraints.Min

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
        val casBudget = budget * 0.07
        val psuBudget = budget * 0.08
        val stoBudget = budget * 0.07

        var cpu = cpuRepository.findAll().filter {
            it.price <= cpuBudget
        }.maxBy { it.price }!!

        val mob = motherboardRepository.findAll().filter {
            it.socket == cpu.socket && it.price <= mobBudget
        }.maxBy { it.price }!!

        val ram = memoryRepository.findAll().filter {
            it.price <= ramBudget && it.moduleCount * it.moduleCapacityGB < mob.maxMemoryLimitGB && it.speed <= mob.maxMemorySpeed
        }.maxBy { it.price }!!

        val gpu = gpuRepository.findAll().filter {
            it.price <= gpuBudget
        }.maxBy { it.price }!!

        val case = caseRepository.findAll().filter {
            it.price <= casBudget && it.formFactor == mob.formFactor && it.maxGPULength >= gpu.length
        }.maxBy { it.price }!!

        val psu = powerSupplyRepository.findAll().filter {
            it.price <= psuBudget && it.formFactor == case.psuFormFactor
        }.maxBy { it.price }!!

        val storage = arrayListOf(storageRepository.findAll().filter { it.price <= stoBudget }.maxBy { it.price }!!)

        var cost = cpu.price + mob.price + gpu.price + ram.price + case.price + psu.price + storage.first().price
        var remainingBudget = budget - cost

        val cooler = coolerRepository.findAll().filter {
            it.price <= remainingBudget && it.supportedSockets.contains(mob.socket) && (!it.isLiquidCooler || it.radiatorSize <= case.maxRadiatorSupport)
        }.maxBy {
            it.price
        } ?: if (cpu.includedCoolerName != null)
            coolerRepository.findByName(cpu.includedCoolerName!!)
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

        remainingBudget -= cooler.price
        cost += cooler.price

        cpu = cpuRepository.findAllByPriceLessThan(cpuBudget + remainingBudget).filter { it.socket == mob.socket }
            .maxBy { it.price }!!

        while (remainingBudget > storageRepository.findAll().minBy { it.price }!!.price && storage.size < 3) {
            val tempStorage = storageRepository.findAll().filter { it.price <= remainingBudget }.maxBy { it.price }!!
            storage.add(tempStorage)
            remainingBudget -= tempStorage.price
            cost += tempStorage.price
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
            price = cost
        )
    }
}