package io.github.kjm015.kylenewer.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import io.github.kjm015.kylenewer.message.SkyrimQuotes

class QuoteCommand : Command() {

    private var quotes = SkyrimQuotes()

    init {
        this.hidden = true
        this.name = "Skyrim"
    }

    override fun execute(event: CommandEvent) {
        event.reply(quotes.getQuote())
    }

}