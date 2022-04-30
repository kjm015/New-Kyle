package io.github.kjm015.newkyle.commands

import com.jagrosh.jdautilities.command.Command
import masecla.reddit4j.exceptions.AuthenticationException
import com.jagrosh.jdautilities.command.CommandEvent
import io.github.kjm015.newkyle.service.RedditService
import io.github.kjm015.newkyle.service.customDescription
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class RedditCommand(private val redditService: RedditService) : Command() {

    private val log = LoggerFactory.getLogger(this.javaClass)

    init {
        this.name = "reddit"
        this.aliases = arrayOf("subreddit", "sub")
        this.help = "Kyle will look something up on Reddit"
        this.guildOnly = false
        this.arguments = "<subreddit_name>"
    }

    override fun execute(event: CommandEvent) {
        event.message.channel.sendTyping().queue()
        if (event.args.isBlank()) {
            event.replyError("You have to provide a subreddit name!")
        } else {
            try {
                val sub = redditService.getSubreddit(event.args)
                if (sub.iconImage.isNotBlank())
                    event.replySuccess(sub.iconImage)
                Thread.sleep(100)
                event.replySuccess(sub.customDescription())
            } catch (e: AuthenticationException) {
                log.error("Reddit4J client could not connect to Reddit API -> ${e.stackTraceToString()}")
                event.replyError("Dang, something went wrong!")
            } catch (e: Exception) {
                log.error("Error fetching subreddit from service -> ${e.stackTraceToString()}")
                event.replyError("I couldn't find any subreddits with that name.")
            }
        }
    }
}