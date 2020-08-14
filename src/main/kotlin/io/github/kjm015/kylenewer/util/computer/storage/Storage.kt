package io.github.kjm015.kylenewer.util.computer.storage

import javax.persistence.*

@Entity
data class Storage (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(unique = true)
        val id: Long = -1L,

        val manufacturer: String = "Unknown",
        val name: String = "Storage",

        val capacityGB: Long = -1,
        val formFactor: String = "Unknown",
        val boardInterface: String = "Unknown",
        val isNVMe: Boolean = false,

        var price: Double = 0.0
) {
        fun productName(): String = "$manufacturer $name"
}