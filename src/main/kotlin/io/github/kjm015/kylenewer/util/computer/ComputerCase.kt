package io.github.kjm015.kylenewer.util.computer

import io.github.kjm015.kylenewer.util.computer.motherboard.MotherboardFormFactor
import io.github.kjm015.kylenewer.util.computer.psu.PowerSupplyFormFactor

data class ComputerCase (
        var name: String,
        var manufacturer: String,
        var formFactor: MotherboardFormFactor,
        var psuFormFactor: PowerSupplyFormFactor,
        var maxRadiatorSupport: Int,
        var maxGPULength: Int,
        var price: Double
)