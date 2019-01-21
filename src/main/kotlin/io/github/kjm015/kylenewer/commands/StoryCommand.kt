package io.github.kjm015.kylenewer.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import io.github.kjm015.kylenewer.util.StoryGenerator

/**
 * Kyle will generate a story from the StoryGenerator class. These stories are
 * compiled from the top posts on reddit.com/r/thatHappened, which is basically
 * a series of hilarious "true" stories.
 *
 * @author kjm015
 * @since 01/20/2019
 */
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