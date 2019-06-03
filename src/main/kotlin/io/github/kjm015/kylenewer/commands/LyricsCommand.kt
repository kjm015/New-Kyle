package io.github.kjm015.kylenewer.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import com.jagrosh.jlyrics.LyricsClient
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 * This command allows Kyle to post lyrics of a song. He will display the name of the song, the author,
 * and the contents of the lyrics.
 *
 * Lyrics API is courtesy of John A. Grosh.
 * See <a href="https://github.com/jagrosh">https://github.com/jagrosh</a>
 *
 * @author kjm015
 * @since 01/20/2019
 */
@Component
class LyricsCommand : Command() {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    private val lyrics: LyricsClient = LyricsClient()

    init {
        this.name = "lyrics"
        this.arguments = "<song name>"
        this.help = "Kyle will get some lyrics for a song of your choice"
        this.aliases = arrayOf("sing", "song")
        this.guildOnly = false
    }

    override fun execute(event: CommandEvent) {
        // Kyle will say that he is typing...
        event.channel.sendTyping()

        // Attempt to retrieve lyrics
        try {
            val song = lyrics.getLyrics(event.args).get()
            event.reply("Getting ${song.title} by ${song.author}...\n\n")
            event.reply(song.content)
        } catch (e: Exception) {
            log.error("Could not fetch lyrics: $e")
            event.replyError("I don't know any song named \"${event.args}\".")
        }
    }

}