package io.github.kjm015.kylenewer.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import kotlin.random.Random

class ComputerCommand : Command() {

    init {
        this.name = "computer"
        this.help = "Kyle will spit out a computer for you."
        this.aliases = arrayOf("cpu", "gpu", "pc")
        this.guildOnly = false
        this.cooldown = 3
    }

    override fun execute(event: CommandEvent) {
        val gpu = generateNvidiaCard()

        val cpu = if (Random.nextBoolean())
            generateIntelProcessor()
        else
            generateRyzenProcessor()

        event.reply("I would get a PC with ${gpu.toString().withArticle()} and ${cpu.toString().withArticle()}.")
    }
}

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
    override fun toString(): String = if (!prefix.equals("TITAN", ignoreCase = true)) {
        "$company $prefix $generation$tier $extension"
    } else if (prefix.equals("TITAN", ignoreCase = true) && generation < 10) {
        "$company GTX $prefix $extension"
    } else {
        "$company $prefix $extension"
    }
}

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
    val extensions = arrayListOf("", "X", "G", "GE")

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
            (generation > 16 && tier < 60) ||
            (generation == 16 && tier !in 50..60) ||
            (generation == 10 && tier < 30) ||
            (generation == 9 && tier < 50)
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
            20 -> if (tier > 80) {
                "RTX"
            } else if (Random.nextBoolean() && tier == 80) {
                "Ti"
            } else {
                "Super"
            }

            16 -> if (Random.nextBoolean() && tier == 60) {
                "Ti"
            } else {
                "Super"
            }

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

fun String.withArticle(): String {
    return if (
            this.startsWith(prefix = "a", ignoreCase = true) ||
            this.startsWith(prefix = "e", ignoreCase = true) ||
            this.startsWith(prefix = "i", ignoreCase = true) ||
            this.startsWith(prefix = "o", ignoreCase = true) ||
            this.startsWith(prefix = "u", ignoreCase = true)
    )
        "an $this"
    else
        "a $this"
}