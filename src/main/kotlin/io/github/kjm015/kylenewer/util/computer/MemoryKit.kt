package io.github.kjm015.kylenewer.util.computer

data class MemoryKit (
        val manufacturer: String,
        val name: String,
        val memoryGeneration: MemoryGeneration,
        val speed: Int,
        val casLatency: Int,
        val hasRGB: Boolean,
        var price: Double
)

enum class MemoryGeneration {
    DDR, DDR2, DDR3, DDR4, DDR5
}