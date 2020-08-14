package io.github.kjm015.kylenewer.util.computer.cooler

import javax.persistence.*

@Entity
data class CPUCooler (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(unique = true)
        var id: Long = -1L,

        val manufacturer: String = "Unknown",
        val name: String = "Cooler",
        val isLiquidCooler: Boolean = false,
        val radiatorSize: Int = -1,
        val fanSize: Int = -1,
        val fanCount: Int = -1,
        val hasRGB: Boolean = false,
        val height: Int = -1,

        @Lob
        val supportedSockets: ArrayList<String> = arrayListOf(),

        var price: Double = 0.00
)