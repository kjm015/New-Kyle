package io.github.kjm015.kylenewer.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import org.springframework.stereotype.Component

/**
 * This command will let Kyle mock you by saying exactly what you just said
 * @author ChiengBang
 * @since 07/05/2020
*/
@Component
class EchoCommand : Command() {
    init {
        this.name = "echo"
        this.help = "Kyle will mock you by saying exactly what you just said"
        this.arguments = "text"
    }

    override fun execute(event: CommandEvent) {
        if (event.args.isBlank()) {
            event.replyError("Type something dummy")
        } else {
            event.reply(event.args)
        }
    }
}