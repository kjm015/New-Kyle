package io.github.kjm015.kylenewer.util.computer.psu

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class PowerSupplyLoader(private val repository: PowerSupplyRepository) : ApplicationRunner {
    override fun run(args: ApplicationArguments) {
        listOf(
                PowerSupply(
                        manufacturer = "EVGA",
                        name = "W3 450 W",
                        wattage = 450,
                        modularity = Modularity.NONE,
                        efficiency = EightyPlusEfficiency.WHITE,
                        formFactor = PowerSupplyFormFactor.ATX,
                        price = 44.99
                ),
                PowerSupply(
                        manufacturer = "SeaSonic",
                        name = "S12III 500 W",
                        wattage = 500,
                        modularity = Modularity.NONE,
                        efficiency = EightyPlusEfficiency.BRONZE,
                        formFactor = PowerSupplyFormFactor.ATX,
                        price = 54.99
                ),
                PowerSupply(
                        manufacturer = "SeaSonic",
                        name = "S12III 650 W",
                        wattage = 650,
                        modularity = Modularity.NONE,
                        efficiency = EightyPlusEfficiency.BRONZE,
                        formFactor = PowerSupplyFormFactor.ATX,
                        price = 64.99
                ),
                PowerSupply(
                        manufacturer = "be quiet!",
                        name = "Pure Power 11 500 W",
                        wattage = 500,
                        modularity = Modularity.NONE,
                        efficiency = EightyPlusEfficiency.GOLD,
                        formFactor = PowerSupplyFormFactor.ATX,
                        price = 69.90
                ),
                PowerSupply(
                        manufacturer = "EVGA",
                        name = "BR 700 W",
                        wattage = 700,
                        modularity = Modularity.NONE,
                        efficiency = EightyPlusEfficiency.BRONZE,
                        formFactor = PowerSupplyFormFactor.ATX,
                        price = 74.99
                ),
                PowerSupply(
                        manufacturer = "EVGA",
                        name = "B5 550 W",
                        wattage = 550,
                        modularity = Modularity.FULL,
                        efficiency = EightyPlusEfficiency.BRONZE,
                        formFactor = PowerSupplyFormFactor.ATX,
                        price = 79.99
                ),
                PowerSupply(
                        manufacturer = "Cooler Master",
                        name = "MWE Gold 650 W",
                        wattage = 550,
                        modularity = Modularity.FULL,
                        efficiency = EightyPlusEfficiency.GOLD,
                        formFactor = PowerSupplyFormFactor.ATX,
                        price = 99.99
                ),
                PowerSupply(
                        manufacturer = "Fractal Design",
                        name = "Ion+ 560 W",
                        wattage = 560,
                        modularity = Modularity.FULL,
                        efficiency = EightyPlusEfficiency.PLATINUM,
                        formFactor = PowerSupplyFormFactor.ATX,
                        price = 100.99
                ),
                PowerSupply(
                        manufacturer = "be quiet!",
                        name = "Pure Power 11 CM 700 W",
                        wattage = 700,
                        modularity = Modularity.SEMI,
                        efficiency = EightyPlusEfficiency.GOLD,
                        formFactor = PowerSupplyFormFactor.ATX,
                        price = 109.90
                ),
                PowerSupply(
                        manufacturer = "SeaSonic",
                        name = "FOCUS 750 W",
                        wattage = 750,
                        modularity = Modularity.SEMI,
                        efficiency = EightyPlusEfficiency.GOLD,
                        formFactor = PowerSupplyFormFactor.ATX,
                        price = 109.99
                ),
                PowerSupply(
                        manufacturer = "Corsair",
                        name = "SF 600 W",
                        wattage = 600,
                        modularity = Modularity.FULL,
                        efficiency = EightyPlusEfficiency.GOLD,
                        formFactor = PowerSupplyFormFactor.SFX,
                        price = 124.99
                ),
                PowerSupply(
                        manufacturer = "Corsair",
                        name = "RM 850 W",
                        wattage = 850,
                        modularity = Modularity.FULL,
                        efficiency = EightyPlusEfficiency.GOLD,
                        formFactor = PowerSupplyFormFactor.ATX,
                        price = 139.99
                ),
                PowerSupply(
                        manufacturer = "SeaSonic",
                        name = "FOCUS Plus Gold 1000 W",
                        wattage = 1000,
                        modularity = Modularity.FULL,
                        efficiency = EightyPlusEfficiency.GOLD,
                        formFactor = PowerSupplyFormFactor.ATX,
                        price = 169.99
                ),
                PowerSupply(
                        manufacturer = "be quiet!",
                        name = "Straight Power 11 1000W",
                        wattage = 1000,
                        modularity = Modularity.FULL,
                        efficiency = EightyPlusEfficiency.PLATINUM,
                        formFactor = PowerSupplyFormFactor.ATX,
                        price = 219.00
                )
        ).forEach {
            if (!repository.existsByName(it.name)) {
                repository.save(it)
            }
        }
    }
}