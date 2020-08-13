package io.github.kjm015.kylenewer.util.computer

data class CPUCooler (
        val manufacturer: String,
        var name: String,
        var isLiquidCooler: Boolean,
        var radiatorSize: Int,
        var fanSize: Int,
        var hasRGB: Boolean,
        var price: Double
)