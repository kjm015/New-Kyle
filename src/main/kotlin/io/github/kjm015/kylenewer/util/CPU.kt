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

    while ((generation < 3 && tier > 7)) {
        tier = tiers.shuffled().random()
        generation = generations.shuffled().random()
    }

    val serial = when (tier) {
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

    val extension = when (tier) {
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
            serial == 600 || (generation > 2 && serial == 500) -> if (Random.nextBoolean()) "X" else ""
            else -> ""
        }

        7 -> if ((generation > 2 || serial > 700) || Random.nextBoolean()) "X" else ""

        9 -> if (serial == 900 && Random.nextBoolean()) "" else "X"

        else -> ""
    }


    return CPU(
            company = "AMD",
            series = "Ryzen",
            tier = tier,
            generation = generation,
            serial = serial,
            extension = extension
    )
}

fun generateIntelProcessor(): CPU {
    val tiers = arrayListOf(3, 5, 7, 9)
    val generations = arrayListOf(2, 3, 4, 5, 6, 7, 8, 9)
    val extensions = arrayListOf("", "K", "KF", "F")

    var tier = tiers.random()
    var generation = generations.random()

    while (tier > 7 && generation < 9) {
        tier = tiers.random()
        generation = generations.random()
    }

    val serial = when (tier) {
        9 -> (90 + Random.nextInt(9)) * 10
        else -> Random.nextInt(99) * 10
    }

    return CPU(
            company = "Intel",
            series = "Core i",
            tier = tier,
            generation = generation,
            serial = serial,
            extension = extensions.random()
    )
}