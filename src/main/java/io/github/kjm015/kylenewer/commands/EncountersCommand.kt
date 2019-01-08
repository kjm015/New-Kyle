package io.github.kjm015.kylenewer.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent

class EncountersCommand: Command() {
    override fun execute(event: CommandEvent?) {


    }
    init {
        this.name = "encounters"
        this.help = "Kyle will generate random roleplaying encounters"
        this.aliases = arrayOf("roleplay", "rp")
        this.arguments = "<user>"

        // how long after this command gets called before it can be called again
        this.cooldown = 20
    }
}
