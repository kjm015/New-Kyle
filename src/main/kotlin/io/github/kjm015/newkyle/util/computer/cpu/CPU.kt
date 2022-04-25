package io.github.kjm015.newkyle.util.computer.cpu

import net.minidev.json.annotate.JsonIgnore
import javax.persistence.*

@Entity
data class CPU(
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    var id: Long = -1L,

    val company: String = "Unknown",
    val name: String = "CPU",
    val coreCount: Int = -1,
    val threadCount: Int = -1,
    val lithography: Int = -1,
    val socket: String = "Unknown",
    val integratedGraphics: String? = null,
    val includesCooler: Boolean = false,
    val includedCoolerName: String? = null,

    var price: Double = 0.0
)

class CPUList {
    var processors: List<CPU> = listOf()
}
