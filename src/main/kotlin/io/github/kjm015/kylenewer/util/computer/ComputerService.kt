package io.github.kjm015.kylenewer.util.computer

import io.github.kjm015.kylenewer.util.computer.compcase.CaseRepository
import io.github.kjm015.kylenewer.util.computer.cooler.CPUCooler
import io.github.kjm015.kylenewer.util.computer.cooler.CoolerRepository
import io.github.kjm015.kylenewer.util.computer.cpu.CPURepository
import io.github.kjm015.kylenewer.util.computer.gpu.GPURepository
import io.github.kjm015.kylenewer.util.computer.memory.MemoryRepository
import io.github.kjm015.kylenewer.util.computer.motherboard.MotherboardRepository
import io.github.kjm015.kylenewer.util.computer.psu.PowerSupplyRepository
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
        private val powerSupplyRepository: PowerSupplyRepository
) {
    fun buildComputer(budget: Double = 900.00, requester: String = "Someone"): Computer {
        val cpuBudget = budget * 0.20
        val gpuBudget = budget * 0.35
        val mobBudget = budget * 0.15
        val ramBudget = budget * 0.08
        val casBudget = budget * 0.07
        val psuBudget = budget * 0.07
        val stoBudget = budget * 0.08

        val cpu = cpuRepository.findAll().filter {
            it.price <= cpuBudget
        }.maxBy { it.price }!!

        val mob = motherboardRepository.findAll().filter {
            it.socket == cpu.socket && it.price <= mobBudget
        }.maxBy { it.price }!!

        val ram = memoryRepository.findAll().filter {
            it.price <= ramBudget && (it.moduleCount * it.moduleCapacityGB) < mob.maxMemoryLimitGB && it.speed <= mob.maxMemorySpeed
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

        val cost = cpu.price + mob.price + gpu.price + ram.price + case.price + psu.price
        val remainingBudget = budget - cost

        val cooler = coolerRepository.findAll().filter {
            it.price <= remainingBudget && it.supportedSockets.contains(mob.socket) && (!it.isLiquidCooler || it.radiatorSize <= case.maxRadiatorSupport)
        }.maxBy {
            it.price
        } ?: if (cpu.includedCoolerName != null)
            coolerRepository.findByName(cpu.includedCoolerName)
        else
            CPUCooler()

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
                price = cost + cooler.price
        )
    }
}