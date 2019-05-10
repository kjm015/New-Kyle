package io.github.kjm015.kylenewer.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import io.github.kjm015.kylenewer.util.QuotesGenerator

/**
 * This command will make Kyle pull a quote from the QuoteGenerator class.
 * For right now, the only thing in there is Skyrim. We'll work on adding
 * more stuff to this later.
 *
 * @author kjm015
 * @since 1/20/2019
 */
class QuoteCommand : Command() {

    private var quotes = QuotesGenerator()

    init {
        this.name = "quote"
        this.aliases = arrayOf("recite", "reference")
        this.arguments = "<source of quote>"
        this.help = "Kyle will pull some quote from a source, maybe. Probably not."
        this.guildOnly = false
    }

    override fun execute(event: CommandEvent) {
        if (event.args.contains("Skyrim", ignoreCase = true)) {
            event.reply(quotes.getSkyrimQuote())
        } else if (event.args.contains("Rolf", ignoreCase = true) || event.args.contains("edd", ignoreCase = true)) {
            event.reply(quotes.getRolfQuote())
        } else if (event.args.isEmpty()) {
            event.reply("I can't think of anything off the top of my head...")
        }
    }

}