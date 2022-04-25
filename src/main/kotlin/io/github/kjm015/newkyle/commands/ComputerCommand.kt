package io.github.kjm015.newkyle.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import io.github.kjm015.newkyle.util.computer.ComputerService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.lang.Exception
import kotlin.random.Random

@Component
class ComputerCommand(private val computerService: ComputerService) : Command() {

    private val log = LoggerFactory.getLogger(this.javaClass)

    init {
        this.name = "computer"
        this.help = "Kyle will spit out a computer for you."
        this.aliases = arrayOf("cpu", "gpu", "pc")
        this.guildOnly = false
        this.arguments = "[budget]"
        this.cooldown = 3
    }

    override fun execute(event: CommandEvent) {
        val rando = Random.nextDouble(750.00, 2500.00)
        val budget = if (event.args.isBlank()) {
            rando
        } else {
            try {
                event.args.toDouble()
            } catch (e: Exception) {
                log.error("User attempted to input invalid budget value -> $e")
                event.replyError("That's not a valid number! Here's my best guess at your budget...")
                rando
            }
        }

        try {
            val computer = computerService.buildComputer(budget, event.author.name)
            event.replySuccess(computer.specList())
        } catch (e: Exception) {
            log.error("Failed to create PC for user \"${event.author.name}\" -> $e")
            event.replyError("Sorry, it seems you can't afford that right about now!")
        }
    }
}