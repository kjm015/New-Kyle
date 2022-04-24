package io.github.kjm015.kylenewer.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import io.github.kjm015.kylenewer.repository.StoryEntry
import io.github.kjm015.kylenewer.util.StoryService
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
        event.args.startsWith(prefix = "add", ignoreCase = true) -> try {
            val argMatey = event.args.drop(n = "add".length + 1)

            when {
                argMatey.startsWith("se", ignoreCase = true) -> {
                    generator.storeStoryComponent(
                            category = "setup",
                            text = argMatey.substringAfter(delimiter = " "),
                            author = event.author.name
                    )

                    event.replySuccess("Okay, got it.")
                }
                argMatey.startsWith("an", ignoreCase = true) -> {
                    generator.storeStoryComponent(
                            category = "antagonism",
                            text = argMatey.substringAfter(delimiter = " "),
                            author = event.author.name
                    )

                    event.replySuccess("Okay, got it.")
                }
                argMatey.startsWith("re", ignoreCase = true) -> {
                    generator.storeStoryComponent(
                            category = "retort",
                            text = argMatey.substringAfter(delimiter = " "),
                            author = event.author.name
                    )

                    event.replySuccess("Okay, got it.")
                }
                argMatey.startsWith("af", ignoreCase = true) -> {
                    generator.storeStoryComponent(
                            category = "affirmation",
                            text = argMatey.substringAfter(delimiter = " "),
                            author = event.author.name
                    )

                    event.replySuccess("Okay, got it.")
                }
                argMatey.startsWith("sn", ignoreCase = true) -> {
                    generator.storeStoryComponent(
                            category = "snark",
                            text = argMatey.substringAfter(delimiter = " "),
                            author = event.author.name
                    )

                    event.replySuccess("Okay, got it.")
                }

                else -> {
                    event.replyError("\"${argMatey.substringBefore(delimiter = " ")}\" is not a valid story category, my guy.")
                }
            }

            log.debug("${event.author.name} tried to create a story component!")
        } catch (e: Exception) {
            log.error("Could not save story entry! -> $e")
            event.replyError("No can do!")
        }

        event.args.startsWith(prefix = "get", ignoreCase = true) -> {
            event.reply("Let me check what I've got...\n")
            generator.getAllStoryComponents().sortedBy {
                it.category
            }.forEachIndexed { i: Int, storyEntry: StoryEntry ->
                event.reply("${i + 1}. ${storyEntry.category.replaceFirstChar { it.uppercase() }} by ${storyEntry.author}: \"${storyEntry.text}\"")
            }

            event.replySuccess("\nThat's all I've got.")
        }

        event.args.startsWith(prefix = "custom", ignoreCase = true) -> {
            try {
                event.reply(generator.customStory())
            } catch (e: NoSuchElementException) {
                log.error("User attempted to get a custom story, but could not -> $e")
                event.replyError("I don't have enough to work with to make a custom story!")
            }
        }

        else -> event.reply(generator.story())
    }
}
