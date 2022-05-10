package io.github.kjm015.newkyle.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import io.github.kjm015.newkyle.repository.StoryEntry
import io.github.kjm015.newkyle.util.StoryService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 * Kyle will generate a story from the StoryService class. These stories are
 * compiled from the top posts on reddit.com/r/thatHappened, which is basically
 * a series of hilarious "true" stories.
 *
 * @author kjm015
 * @since 01/20/2019
 */
@Component
class StoryCommand(private val generator: StoryService) : Command() {

    private val log = LoggerFactory.getLogger(this.javaClass)

    init {
        this.name = "story"
        this.aliases = arrayOf("tale", "fable")
        this.help = "Kyle will tell you a story about a recent occurrence in his life."
        this.guildOnly = false
    }

    override fun execute(event: CommandEvent) = when {

        event.args.startsWith(prefix = "get", ignoreCase = true) -> {
            event.reply("Let me check what I've got...\n")
            generator.getAllStoryComponents().sortedBy {
                it.category
            }.forEachIndexed { i: Int, storyEntry: StoryEntry ->
                event.reply("${i + 1}. ${storyEntry.category.replaceFirstChar { it.uppercase() }} by ${storyEntry.author}: \"${storyEntry.text}\"")
            }

            event.replySuccess("\nThat's all I've got.")
        }

        else -> event.reply(generator.story())
    }
}
