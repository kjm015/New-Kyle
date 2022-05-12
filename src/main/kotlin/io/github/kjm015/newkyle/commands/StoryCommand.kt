package io.github.kjm015.newkyle.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import io.github.kjm015.newkyle.util.StoryService
import org.springframework.stereotype.Component

/**
 * Kyle will generate a story from the StoryService class.
 *
 * @author kjm015
 * @since 01/20/2019
 */
@Component
class StoryCommand(private val generator: StoryService) : Command() {

  init {
    this.name = "story"
    this.aliases = arrayOf("tale", "fable")
    this.help = "Kyle will tell you a story about a recent occurrence in his life."
    this.guildOnly = false
  }

  override fun execute(event: CommandEvent) {
    event.channel.sendTyping().queue()
    event.reply(generator.story())
  }
}
