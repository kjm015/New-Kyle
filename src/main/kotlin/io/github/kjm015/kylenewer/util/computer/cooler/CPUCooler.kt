package io.github.kjm015.kylenewer.util.computer.cooler

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import net.minidev.json.annotate.JsonIgnore
import javax.persistence.*

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
data class CPUCooler(
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    var id: Long = -1L,

    val manufacturer: String = "",
    val name: String = "",

    val isLiquidCooler: Boolean = false,

    val radiatorSize: Int = 0,
    val fanSize: Int = 0,
    val fanCount: Int = 0,
    val hasRGB: Boolean = false,
    val height: Int = 0,

    @Lob
    val supportedSockets: ArrayList<String> = arrayListOf(),

    val price: Double = 0.0
)

class CoolerList {
    var coolers: List<CPUCooler> = listOf()
}
