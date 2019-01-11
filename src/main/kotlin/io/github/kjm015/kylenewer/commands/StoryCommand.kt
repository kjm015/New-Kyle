package io.github.kjm015.kylenewer.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import io.github.kjm015.kylenewer.util.StoryGenerator

class StoryCommand : Command() {

    private val generator = StoryGenerator()

    init {
        this.name = "story"
        this.aliases = arrayOf("tale", "fable")
        this.help = "Kyle will tell you a story about a recent occurrence in his life."

    }

    override fun execute(event: CommandEvent) {
        event.reply(generator.story())
    }

}