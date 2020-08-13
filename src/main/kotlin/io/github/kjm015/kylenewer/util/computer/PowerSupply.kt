package io.github.kjm015.kylenewer.util.computer

data class PowerSupply (
        val name: String,
        val wattage: Int,
        val modularity: Modularity,
        val efficiency: EightyPlusEfficiency,
        val formFactor: PowerSupplyFormFactor,
        var price: Double
)

enum class Modularity {
    NONE, SEMI, FULL
}

enum class EightyPlusEfficiency {
    NONE, WHITE, BRONZE, SILVER, GOLD, PLATINUM, TITANIUM
}

enum class PowerSupplyFormFactor {
    SFX, SFXL, ATX, HFX
}