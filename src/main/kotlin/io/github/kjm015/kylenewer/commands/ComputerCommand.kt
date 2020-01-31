package io.github.kjm015.kylenewer.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import io.github.kjm015.kylenewer.util.*
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
        val gpu = if (Random.nextBoolean())
            generateNvidiaCard()
        else
            generateRadeonCard()

        val cpu = if (Random.nextBoolean())
            generateIntelProcessor()
        else
            generateRyzenProcessor()

        val motherboard = if (cpu.company == "AMD") {
            generateRandomAM4Motherboard()
        } else {
            generateLGA1151Motherboard(cpu.generation)
        }

        event.reply("I would get a PC with ${gpu.toString().withArticle()} and " +
                "${cpu.toString().withArticle()} on " +
                "${motherboard.toString().withArticle()}.")
    }
}