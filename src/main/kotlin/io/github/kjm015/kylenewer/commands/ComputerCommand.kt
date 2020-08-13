package io.github.kjm015.kylenewer.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent

class ComputerCommand : Command() {

    init {
        this.name = "computer"
        this.help = "Kyle will spit out a computer for you."
        this.aliases = arrayOf("cpu", "gpu", "pc")
        this.guildOnly = false
        this.cooldown = 3
    }

    override fun execute(event: CommandEvent) {
        event.replyError("Oof.")
    }
}