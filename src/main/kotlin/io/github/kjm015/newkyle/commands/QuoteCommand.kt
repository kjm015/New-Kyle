package io.github.kjm015.newkyle.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import io.github.kjm015.newkyle.util.QuotesService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 * This command will make Kyle pull a quote from the QuoteGenerator class.
 * For right now, the only thing in there is Skyrim. We'll work on adding
 * more stuff to this later.
 *
 * @author kjm015
 * @since 1/20/2019
 */
@Component
class QuoteCommand(private val quotes: QuotesService) : Command() {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    init {
        this.name = "quote"
        this.aliases = arrayOf("recite", "reference")
        this.arguments = "<source of quote>"
        this.help = "Kyle will pull some quote from a source, maybe. Probably not."
        this.guildOnly = false
    }

    override fun execute(event: CommandEvent) {
        event.channel.sendTyping().queue()

        try {
            if (event.args.isNotEmpty()) {
                event.replySuccess(quotes.getQuoteFromSource(event.args).displayString())
            } else {
                event.replySuccess(quotes.getRandomQuote().displayString())
            }
        } catch (e: Exception) {
            log.error("Could not get quote from quote service ->\n${e.stackTraceToString()}")
            event.replyError("I can't think of anything off the top of my head...")
        }
    }
}