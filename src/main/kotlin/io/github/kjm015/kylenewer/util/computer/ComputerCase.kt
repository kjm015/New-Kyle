package io.github.kjm015.kylenewer.util.computer

import io.github.kjm015.kylenewer.util.computer.motherboard.MotherboardFormFactor

data class ComputerCase (
        var name: String,
        var manufacturer: String,
        var formFactor: MotherboardFormFactor,
        var psuFormFactor: PowerSupplyFormFactor,
        var maxRadiatorSupport: Int,
        var maxGPULength: Int,
        var price: Double
)