package io.github.kjm015.kylenewer.util.computer

import io.github.kjm015.kylenewer.util.computer.compcase.ComputerCase
import io.github.kjm015.kylenewer.util.computer.cooler.CPUCooler
import io.github.kjm015.kylenewer.util.computer.cpu.CPU
import io.github.kjm015.kylenewer.util.computer.gpu.GraphicsCard
import io.github.kjm015.kylenewer.util.computer.memory.MemoryKit
import io.github.kjm015.kylenewer.util.computer.motherboard.Motherboard
import io.github.kjm015.kylenewer.util.computer.psu.PowerSupply
import io.github.kjm015.kylenewer.util.computer.storage.Storage
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
        Memory       | ${memory.manufacturer} ${memory.name} ($${memory.price})
        Storage      | ${storage.map { it.productName() }} ($${storage.sumByDouble { it.price }})
        GPU          | ${gpu.manufacturer} ${gpu.productName} ($${gpu.price})
        Case         | ${case.manufacturer} ${case.name} ($${case.price})
        Power Supply | ${powerSupply.manufacturer} ${powerSupply.name} ($${powerSupply.price})
        --------------------------
        Total Cost   | $${price.toBigDecimal().setScale(2, RoundingMode.HALF_EVEN)} `
    """.trimIndent()
}