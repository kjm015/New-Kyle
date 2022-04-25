package io.github.kjm015.newkyle.util.computer.psu

import net.minidev.json.annotate.JsonIgnore
import javax.persistence.*

@Entity
data class PowerSupply(
        @Id
        @JsonIgnore
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(unique = true)
        var id: Long = -1L,

        val manufacturer: String = "Unknown",
        val name: String = "Power Supply",
        val wattage: Int = -1,
        val modularity: Modularity = Modularity.NONE,
        val efficiency: EightyPlusEfficiency = EightyPlusEfficiency.NONE,
        val formFactor: PowerSupplyFormFactor = PowerSupplyFormFactor.UNKNOWN,

        var price: Double = 0.00
)

enum class Modularity {
    NONE, SEMI, FULL
}

enum class EightyPlusEfficiency {
    NONE, WHITE, BRONZE, SILVER, GOLD, PLATINUM, TITANIUM
}

enum class PowerSupplyFormFactor {
    SFX, SFXL, ATX, HFX, UNKNOWN
}

class PSUList {
    var powerSupplies: List<PowerSupply> = listOf()
}