package io.github.kjm015.kylenewer.util

import kotlin.random.Random

data class CPU(
        val company: String,
        val series: String,
        val tier: Int,
        val generation: Int,
        val serial: Int,
        val extension: String
) {
    override fun toString(): String {
        return if (company.equals("Intel", ignoreCase = true))
            "$company ${series}${tier}-${generation}${serial}${extension}"
        else
            "$company $series $tier ${generation}${serial}${extension}"
    }
}


fun generateRyzenProcessor(): CPU {
    val tiers = arrayListOf(3, 5, 7, 9)
    val generations = arrayListOf(1, 2, 3)

    var tier = tiers.shuffled().random()
    var generation = generations.shuffled().random()

    while (generation < 3 && tier > 7) {
        tier = tiers.shuffled().random()
        generation = generations.shuffled().random()
    }

    val serial = getRyzenSerialNumber(tier = tier, generation = generation)
    val extension = getRyzenExtension(tier = tier, generation = generation, serial = serial)

    return CPU(
            company = "AMD",
            series = "Ryzen",
            tier = tier,
            generation = generation,
            serial = serial,
            extension = extension
    )
}

fun getRyzenSerialNumber(tier: Int, generation: Int): Int = when (tier) {
    3 -> when {
        generation < 3 && Random.nextBoolean() -> 300
        else -> 200
    }

    5 -> when {
        Random.nextBoolean() -> 400
        Random.nextBoolean() -> 500
        else -> 600
    }

    7 -> if (Random.nextBoolean() || generation == 2) 700 else 800

    9 -> if (Random.nextBoolean()) 900 else 950

    else -> 0
}

fun getRyzenExtension(tier: Int, generation: Int, serial: Int): String = when (tier) {
    3 -> when {
        serial == 200 && generation < 2 -> ""
        serial == 200 && generation > 1 -> "G"
        serial == 300 -> "X"
        else -> ""
    }

    5 -> when {
        generation < 2 && serial == 400 -> ""
        generation > 1 && serial == 400 -> "G"
        generation < 3 && serial == 500 -> "X"
        serial == 600 || generation > 2 && serial == 500 -> if (Random.nextBoolean()) "X" else ""
        else -> ""
    }

    7 -> if (generation > 2 || serial > 700 || Random.nextBoolean()) "X" else ""

    9 -> if (serial == 900 && Random.nextBoolean()) "" else "X"

    else -> ""
}

fun generateIntelProcessor(): CPU {
    val tiers = arrayListOf(3, 5, 7, 9)
    val generations = arrayListOf(7, 8, 9)
    val extensions = arrayListOf("", "K", "KF", "F", "KS")

    var tier = tiers.random()
    var generation = generations.random()

    while (tier > 7 && generation < 9) {
        tier = tiers.random()
        generation = generations.random()
    }

    var extension = extensions.random()

    while (extension == "KS" && tier != 9 || extension == "F" && tier > 7) {
        extension = extensions.random()
    }

    val serial = when (tier) {
        9 -> 900
        7 -> 700
        5 -> if (extension.contains("K", ignoreCase = true)) 600 else 400
        3 -> if (extension.contains("K", ignoreCase = true)) 350 else 100
        else -> 100
    }

    return CPU(
            company = "Intel",
            series = "Core i",
            tier = tier,
            generation = generation,
            serial = serial,
            extension = extension
    )
}