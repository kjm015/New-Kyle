package io.github.kjm015.kylenewer.util

import kotlin.random.Random

data class Motherboard(
        val manufacturer: String,
        val chipSet: String,
        val modelName: String,
        val socket: String,
        val formFactor: String,
        val dimSlots: Int
) {
    override fun toString(): String {
        return "$manufacturer $chipSet $formFactor motherboard"
    }
}

val manufacturers = arrayListOf("ASUS", "Gigabyte", "MSI", "ASRock")
val formFactors = arrayListOf("ATX", "EATX", "mATX", "ITX")

fun generateRandomAM4Motherboard(): Motherboard {
    val manufacturer = manufacturers.random()
    val amdChipSets = arrayListOf("A320", "B350", "X370", "B450", "X470", "B550", "X570")

    val socket = "AM4"
    val chipSet = amdChipSets.random()

    val formFactor = formFactors.random()
    val dimmSlots = if (formFactor == "ITX")
        2
    else if (formFactor == "mATX" && Random.nextBoolean())
        2
    else
        4

    return Motherboard(
            manufacturer = manufacturer,
            chipSet = chipSet,
            modelName = "Gaming",
            socket = socket,
            formFactor = formFactor,
            dimSlots = dimmSlots
    )
}

fun generateLGA1151Motherboard(generation: Int): Motherboard {
    val manufacturer = manufacturers.random()

    val intelSocket = "LGA-1151"
    val formFactor = formFactors.random()

    val dimmSlots = if (formFactor == "ITX")
        2
    else
        4

    return Motherboard(
            manufacturer = manufacturer,
            chipSet = getIntelChipset(generation),
            modelName = "Gaming",
            socket = intelSocket,
            formFactor = formFactor,
            dimSlots = dimmSlots
    )
}

fun getIntelChipset(generation: Int): String {
    val intelChipSets6 = arrayListOf("H110", "B150", "Z170")
    val intelChipSets7 = arrayListOf("H210", "B250", "Z270")
    val intelChipSets8 = arrayListOf("H370", "B360", "Z370")
    val intelChipSets9 = arrayListOf("H310", "B365", "Z390")

    return when (generation) {
        9 -> intelChipSets9.random()
        8 -> intelChipSets8.random()
        7 -> intelChipSets7.random()
        6 -> intelChipSets6.random()
        else -> "X79"
    }
}