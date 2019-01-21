package io.github.kjm015.kylenewer.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import com.jagrosh.jlyrics.LyricsClient
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class LyricsCommand: Command() {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    private val lyrics: LyricsClient = LyricsClient()

    init {
        this.name = "lyrics"
        this.arguments = "<song>"
        this.help = "Kyle will get some lyrics for a song of your choice"
        this.aliases = arrayOf("sing", "song")
    }

    override fun execute(event: CommandEvent) {
        try {
            event.reply(lyrics.getLyrics(event.args).get().content)
        } catch (e: Exception) {
            log.error("Could not fetch lyrics: $e")
            event.reply("Couldn't find anything named \"${event.args}\".")
        }
    }

}