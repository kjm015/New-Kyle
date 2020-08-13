package io.github.kjm015.kylenewer.util.computer

import io.github.kjm015.kylenewer.util.computer.cpu.CPU
import io.github.kjm015.kylenewer.util.computer.gpu.GraphicsCard

data class Computer(
        var owner: String,
        var name: String,
        var cpu: CPU,
        var gpu: GraphicsCard,
        var motherboard: Motherboard,
        var powerSupply: PowerSupply,
        var case: ComputerCase,
        var price: Double
)