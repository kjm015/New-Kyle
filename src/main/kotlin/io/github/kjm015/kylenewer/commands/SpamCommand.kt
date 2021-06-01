package io.github.kjm015.kylenewer.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import io.github.kjm015.kylenewer.util.SpamService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.lang.Exception

@Component
class SpamCommand(private val spamService: SpamService) : Command() {

    private val log = LoggerFactory.getLogger(this.javaClass)

    init {
        this.name = "spam"
        this.help = "Kyle will send a spam message better than any of those idiots abroad"
        this.aliases = arrayOf("scam")
        this.guildOnly = true
        this.cooldown = 5
    }

    public override fun execute(event: CommandEvent) {
        try {
            event.channel.sendTyping().queue()
            event.replySuccess(spamService.scamMessage())
        } catch (e: Exception) {
            log.error("Spam service failure: ${e.localizedMessage}")
            event.replyError("Send me money now.")
        }
    }
}