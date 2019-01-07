package io.github.kjm015.kylenewer.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import io.github.kjm015.kylenewer.util.QuotesGenerator

class QuoteCommand : Command() {

    private var quotes = QuotesGenerator()

    init {
        this.name = "quote"
        this.aliases = arrayOf("recite", "reference")
    }

    override fun execute(event: CommandEvent) {
        if (event.args.contains("Skyrim", ignoreCase = true)) {
            event.reply(quotes.getSkyrimQuote())
        } else if (event.args.isEmpty()) {

        }
    }

}