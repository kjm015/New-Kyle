package io.github.kjm015.kylenewer.util.computer.cooler

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class CoolerLoader(private val repository: CoolerRepository) : ApplicationRunner {
    override fun run(args: ApplicationArguments) {
        listOf(
                CPUCooler(
                        manufacturer = "be quiet!",
                        name = "Pure Rock Slim",
                        height = 125,
                        fanCount = 1,
                        fanSize = 92,
                        supportedSockets = arrayListOf("AM4", "LGA1200", "LGA2066"),
                        price = 35.29
                ),
                CPUCooler(
                        manufacturer = "Arctic",
                        name = "Freezer 34 eSports",
                        height = 157,
                        fanCount = 1,
                        fanSize = 120,
                        supportedSockets = arrayListOf("AM4", "LGA1200", "LGA2066"),
                        price = 36.99
                ),
                CPUCooler(
                        manufacturer = "be quiet!",
                        name = "Pure Rock 2 Black",
                        height = 155,
                        fanCount = 1,
                        fanSize = 120,
                        supportedSockets = arrayListOf("AM4", "LGA1200", "LGA2066"),
                        price = 44.90
                ),
                CPUCooler(
                        manufacturer = "be quiet!",
                        name = "Dark Rock Slim",
                        height = 160,
                        fanCount = 1,
                        fanSize = 120,
                        supportedSockets = arrayListOf("AM4", "LGA1200", "LGA2066"),
                        price = 64.99
                ),
                CPUCooler(
                        manufacturer = "be quiet!",
                        name = "Dark Rock 4",
                        height = 160,
                        fanCount = 1,
                        fanSize = 120,
                        supportedSockets = arrayListOf("AM4", "LGA1200", "LGA2066"),
                        price = 74.90
                ),
                CPUCooler(
                        manufacturer = "Noctua",
                        name = "NH-D15 CHROMAX.BLACK",
                        height = 165,
                        fanCount = 2,
                        fanSize = 140,
                        supportedSockets = arrayListOf("AM4", "LGA1200", "LGA2066"),
                        price = 99.95
                ),
                CPUCooler(
                        manufacturer = "Corsair",
                        name = "iCUE H100i RGB PRO XT",
                        height = 50,
                        fanCount = 2,
                        fanSize = 120,
                        isLiquidCooler = true,
                        radiatorSize = 240,
                        hasRGB = true,
                        supportedSockets = arrayListOf("AM4", "LGA1200", "LGA2066", "sTR4", "sTRX4"),
                        price = 119.99
                ),
                CPUCooler(
                        manufacturer = "Arctic",
                        name = "Liquid Freezer II 360",
                        height = 50,
                        fanCount = 3,
                        fanSize = 120,
                        isLiquidCooler = true,
                        radiatorSize = 360,
                        supportedSockets = arrayListOf("AM4", "LGA1200", "LGA2066"),
                        price = 134.99
                ),
                CPUCooler(
                        manufacturer = "NZXT",
                        name = "Kraken X63",
                        height = 50,
                        fanCount = 2,
                        fanSize = 140,
                        isLiquidCooler = true,
                        radiatorSize = 280,
                        hasRGB = true,
                        supportedSockets = arrayListOf("AM4", "LGA1200", "LGA2066", "sTR4", "sTRX4"),
                        price = 149.99
                ),
                CPUCooler(
                        manufacturer = "NZXT",
                        name = "Kraken X73",
                        height = 50,
                        fanCount = 3,
                        fanSize = 120,
                        isLiquidCooler = true,
                        radiatorSize = 360,
                        hasRGB = true,
                        supportedSockets = arrayListOf("AM4", "LGA1200", "LGA2066", "sTR4", "sTRX4"),
                        price = 179.99
                ),
                CPUCooler(
                        manufacturer = "NZXT",
                        name = "Kraken Z63",
                        height = 50,
                        fanCount = 2,
                        fanSize = 140,
                        isLiquidCooler = true,
                        radiatorSize = 280,
                        hasRGB = true,
                        supportedSockets = arrayListOf("AM4", "LGA1200", "LGA2066", "sTR4", "sTRX4"),
                        price = 289.99
                ),
                CPUCooler(
                        manufacturer = "NZXT",
                        name = "Kraken Z73",
                        height = 50,
                        fanCount = 3,
                        fanSize = 120,
                        isLiquidCooler = true,
                        radiatorSize = 360,
                        hasRGB = true,
                        supportedSockets = arrayListOf("AM4", "LGA1200", "LGA2066", "sTR4", "sTRX4"),
                        price = 319.99
                )
        ).forEach {
            if (!repository.existsByName(it.name)) {
                repository.save(it)
            }
        }
    }
}