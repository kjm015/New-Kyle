package io.github.kjm015.kylenewer.util

import kotlin.random.Random

data class GraphicsCard(
        var company: String,

        var manufacturer: String,
        var embellishment: String = "",

        var prefix: String,

        var generation: Int,
        var tier: Int,

        var extension: String = "",

        var model: String = "",
        var memoryAmountInGigabytes: Int
) {
    override fun toString(): String = if (company.equals("Nvidia", ignoreCase = true) && !prefix.equals("TITAN", ignoreCase = true)) {
        "$company $prefix $generation$tier $extension"
    } else if (prefix.equals("TITAN", ignoreCase = true) && generation < 10) {
        "$company GTX $prefix $extension"
    } else if (company == "AMD") {
        "Radeon $prefix ${generation}${tier} $extension"
    } else {
        "$company $prefix $extension"
    }
}

fun generateNvidiaCard(): GraphicsCard {
    val manufacturers = arrayListOf("Palit", "ASUS", "EVGA", "MSI", "Gigabyte", "Zotac", "PNY")
    val generations = arrayListOf(7, 9, 10, 16, 20)
    val tiers = arrayListOf(10, 30, 50, 60, 70, 80, 90)

    // Get random GPU manufacturer
    val manufacturer = manufacturers.shuffled().random()

    // Try to generate something random
    var generation = generations.shuffled().random()
    var tier = tiers.shuffled().random()
    var extension = ""

    // Find illegal generation and tier combinations
    while (
            generation > 16 && tier < 60 ||
            generation == 16 && tier !in 50..60 ||
            generation == 10 && tier < 30 ||
            generation == 9 && tier < 50
    ) {
        generation = generations.shuffled().random()
        tier = tiers.shuffled().random()
    }

    // Get initializer based on tier and generation
    val initializer = when {
        generation > 16 && tier in 60..80 -> "RTX"
        generation < 20 && tier in 50..80 -> "GTX"
        tier > 80 -> "TITAN"
        else -> "GT"
    }

    if (Random.nextBoolean() || tier > 80) {
        extension = when (generation) {
            20 -> if (tier > 80) "RTX" else if (Random.nextBoolean() && tier == 80) "Ti" else "Super"

            16 -> if (Random.nextBoolean() && tier == 60) "Ti" else "Super"

            10 -> when (tier) {
                90 -> "XP"
                80 -> "Ti"
                70 -> "Ti"
                50 -> "Ti"
                else -> ""
            }
            9 -> when (tier) {
                90 -> "X"
                80 -> "Ti"
                else -> ""
            }
            7 -> when (tier) {
                90 -> if (Random.nextBoolean()) "Black" else "Z"
                80 -> "Ti"
                60 -> "Ti"
                50 -> "Ti"
                else -> ""
            }
            else -> ""
        }
    }

    return GraphicsCard(
            company = "Nvidia",
            manufacturer = manufacturer,
            embellishment = "",
            prefix = initializer,
            generation = generation,
            tier = tier,
            extension = extension,
            model = "",
            memoryAmountInGigabytes = 0
    )
}

fun generateRadeonCard(): GraphicsCard {
    val manufacturers = arrayListOf("ASUS", "PowerColor", "MSI", "Gigabyte", "Sapphire", "XFX", "Yeston")
    val generations = arrayListOf(2, 3, 4, 5)
    val tiers = arrayListOf(70, 80, 90)
    val highTiers = arrayListOf(500, 600, 700)

    val generation = generations.random()

    val tier: Int
    var extension = ""

    if (generation == 5 && Random.nextBoolean()) {
        tier = highTiers.random()
        if (Random.nextBoolean())
            extension = "XT"
    } else {
        tier = tiers.random()
        if (generation < 4 && Random.nextBoolean())
            extension = "X"
    }

    val prefix = if (generation < 4) "R9" else "RX"
    val manufacturer = manufacturers.random()

    return GraphicsCard(
            company = "AMD",
            manufacturer = manufacturer,
            embellishment = "",
            prefix = prefix,
            generation = generation,
            tier = tier,
            extension = extension,
            model = "",
            memoryAmountInGigabytes = 0
    )
}