package io.github.kjm015.kylenewer.util.computer

import io.github.kjm015.kylenewer.util.computer.compcase.ComputerCase
import io.github.kjm015.kylenewer.util.computer.cpu.CPU
import io.github.kjm015.kylenewer.util.computer.gpu.GraphicsCard
import io.github.kjm015.kylenewer.util.computer.motherboard.Motherboard
import io.github.kjm015.kylenewer.util.computer.psu.PowerSupply

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