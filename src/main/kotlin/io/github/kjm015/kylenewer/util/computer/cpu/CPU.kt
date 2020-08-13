package io.github.kjm015.kylenewer.util.computer.cpu

import javax.persistence.*
import kotlin.random.Random

@Entity
data class CPU(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(unique = true)
        var id: Long = -1L,

        val company: String = "Unknown",
        val name: String = "CPU",
        val coreCount: Int = -1,
        val threadCount: Int = -1,
        val lithography: Int = -1,
        val socket: String = "Unknown",

        var price: Double = 0.0
)