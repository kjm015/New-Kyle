package io.github.kjm015.kylenewer.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import org.springframework.stereotype.Component

@Component
class EchoCommand : Command() {
    init {
        this.name = "echo"
        this.help = "Tells Kyle whatever you want"
        this.arguments = "a message"
    }

    override fun execute(event: CommandEvent) {
        if (event.args.isBlank()) {
            event.reply("Type something dummy")
        } else {
            event.reply(event.args)
        }
    }
}