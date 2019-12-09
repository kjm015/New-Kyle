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
        return "$manufacturer $chipSet $modelName $formFactor $socket motherboard"
    }
}

val gigabyte: Map<String, ArrayList<String>> = mapOf(
        Pair("Gigabyte",
                arrayListOf(
                        "Aorus Elite",
                        "Aorus M",
                        "Aorus Master",
                        "Aorus Ultra",
                        "Aorus Xtreme",
                        "Aorus Pro WiFi"
                )
        )
)

val asus: Map<String, ArrayList<String>> = mapOf(
        Pair("Asus",
                arrayListOf(
                        "Aorus Elite",
                        "Aorus M",
                        "Aorus Master",
                        "Aorus Ultra",
                        "Aorus Xtreme",
                        "Aorus Pro WiFi"
                )
        )
)

fun generateRandomAM4Motherboard(): Motherboard {
    val manufacturer = arrayListOf("ASUS", "Gigabyte", "MSI", "ASRock").random()
    val amdChipSets = arrayListOf("A320", "B350", "X370", "B450", "X470", "B550", "X570")

    val socket = "AM4"
    val chipSet = amdChipSets.random()

    val formFactor = arrayListOf("ATX", "EATX", "mATX", "ITX").random()
    val dimmSlots = if (formFactor == "ITX")
        2
    else if (formFactor == "mATX" && Random.nextBoolean())
        2
    else
        4

    return Motherboard(
            manufacturer = manufacturer,
            chipSet = chipSet,
            modelName = "",
            socket = socket,
            formFactor = formFactor,
            dimSlots = dimmSlots
    )
}