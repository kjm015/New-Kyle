package io.github.kjm015.newkyle.util.computer

import io.github.kjm015.newkyle.util.computer.compcase.ComputerCase
import io.github.kjm015.newkyle.util.computer.cooler.CPUCooler
import io.github.kjm015.newkyle.util.computer.cpu.CPU
import io.github.kjm015.newkyle.util.computer.gpu.GraphicsCard
import io.github.kjm015.newkyle.util.computer.memory.MemoryKit
import io.github.kjm015.newkyle.util.computer.motherboard.Motherboard
import io.github.kjm015.newkyle.util.computer.psu.PowerSupply
import io.github.kjm015.newkyle.util.computer.storage.Storage
import java.math.RoundingMode

data class Computer(
    var owner: String = "Unknown",
    var name: String = "Computer",
    var cpu: CPU,
    var gpu: GraphicsCard,
    var motherboard: Motherboard,
    var powerSupply: PowerSupply,
    var case: ComputerCase,
    var memory: MemoryKit,
    var cooler: CPUCooler,
    var storage: ArrayList<Storage> = arrayListOf(),

    var price: Double = 0.0
) {
    fun specList() = """ 
        `--------------------------
        $name Specifications
        --------------------------
        CPU          | ${cpu.company} ${cpu.name} ($${cpu.price})
        CPU Cooler   | ${cooler.manufacturer} ${cooler.name} ($${cooler.price})
        Motherboard  | ${motherboard.manufacturer} ${motherboard.modelName} ($${motherboard.price})
        Memory       | ${memory.manufacturer} ${memory.name} ${memory.moduleCount}x ${memory.moduleCapacityGB}GB ${memory.memoryGeneration}-${memory.speed} CL${memory.casLatency} ($${memory.price})
        Storage      | ${storage.map { it.productName() }} ($${storage.sumOf { it.price }})
        GPU          | ${gpu.manufacturer} ${gpu.productName} ($${gpu.price})
        Case         | ${case.manufacturer} ${case.name} ($${case.price})
        Power Supply | ${powerSupply.manufacturer} ${powerSupply.name} ($${powerSupply.price})
        --------------------------
        Total Cost   | $${price.toBigDecimal().setScale(2, RoundingMode.HALF_EVEN)} `
    """.trimIndent()
}