package io.github.kjm015.kylenewer.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent

class StoryCommand : Command() {

    init {
        this.name = "story"
        this.aliases = arrayOf("tale", "fable")
        this.help = "Kyle will tell you a story about his life."
    }

    override fun execute(event: CommandEvent?) {

    }

}