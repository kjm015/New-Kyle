package io.github.kjm015.kylenewer.util.computer.memory

import javax.persistence.*

@Entity
data class MemoryKit(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(unique = true)
        var id: Long = -1L,

        val manufacturer: String = "Unknown",
        val name: String = "RAM",
        val memoryGeneration: MemoryGeneration = MemoryGeneration.UNKNOWN,
        val speed: Int = -1,
        val casLatency: Int = -1,
        val hasRGB: Boolean = false,
        val moduleCount: Int = -1,
        val moduleCapacityGB: Int = -1,
        var price: Double = 0.00
)

enum class MemoryGeneration {
    DDR, DDR2, DDR3, DDR4, DDR5, UNKNOWN
}