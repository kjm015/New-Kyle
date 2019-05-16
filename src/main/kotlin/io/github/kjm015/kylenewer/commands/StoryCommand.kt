package io.github.kjm015.kylenewer.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import io.github.kjm015.kylenewer.repository.StoryEntry
import io.github.kjm015.kylenewer.repository.StoryRepository
import io.github.kjm015.kylenewer.util.StoryGenerator
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Kyle will generate a story from the StoryGenerator class. These stories are
 * compiled from the top posts on reddit.com/r/thatHappened, which is basically
 * a series of hilarious "true" stories.
 *
 * @author kjm015
 * @since 01/20/2019
 */
@Component
class StoryCommand : Command() {

    private val generator = StoryGenerator()

    private val log = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    private lateinit var storyRepo: StoryRepository

    init {
        this.name = "story"
        this.aliases = arrayOf("tale", "fable")
        this.help = "Kyle will tell you a story about a recent occurrence in his life."
        this.guildOnly = false
    }

    override fun execute(event: CommandEvent) = when {
        event.args.startsWith(prefix = "add", ignoreCase = true) -> try {
            val storyEntry = StoryEntry()

            val argMatey = event.args.drop(n = "add".length + 1)

            storyEntry.category = argMatey.substringBefore(delimiter = " ")
            storyEntry.text = argMatey.substringAfter(delimiter = " ")
            storyEntry.author = event.author.name

            storyRepo.save(storyEntry)
            event.replySuccess("Okay, got it.")
        } catch (e: Exception) {
            log.error("Could not save story entry! -> $e")
            event.replyError("No can do!")
        }

        event.args.startsWith(prefix = "get", ignoreCase = true) -> {
            event.reply("Let me check what I've got...\n")
            storyRepo.findAll().forEachIndexed { i: Int, storyEntry: StoryEntry ->
                event.reply("${i + 1}. ${storyEntry.category} by ${storyEntry.author}: \"${storyEntry.text}\"")
            }
            event.replySuccess("\nThat's all I've got.")
        }

        else -> event.reply(generator.story())
    }

}
