package io.github.kjm015.kylenewer.util.computer.motherboard

import io.github.kjm015.kylenewer.util.computer.memory.MemoryGeneration
import javax.persistence.*

@Entity
data class Motherboard(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(unique = true)
        var id: Long = -1L,

        val manufacturer: String = "Unknown",
        val chipSet: String = "Unknown",
        val modelName: String = "Motherboard",

        val socket: String = "Unknown",
        val formFactor: MotherboardFormFactor = MotherboardFormFactor.UNKNOWN,
        val memorySlots: Int = -1,
        val maxMemoryLimitGB: Int = -1,
        val maxMemorySpeed: Int = -1,
        val memoryType: MemoryGeneration = MemoryGeneration.UNKNOWN,

        val wifiType: Int = 0,

        var price: Double = 0.0
)

enum class MotherboardFormFactor {
    ATX, MATX, DTX, ITX, EATX, UNKNOWN
}