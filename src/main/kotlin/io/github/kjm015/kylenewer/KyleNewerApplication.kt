package io.github.kjm015.kylenewer

import com.jagrosh.jdautilities.command.CommandClientBuilder
import com.jagrosh.jlyrics.LyricsClient
import io.github.kjm015.kylenewer.commands.*
import io.github.kjm015.kylenewer.listeners.ExodusListener
import io.github.kjm015.kylenewer.listeners.InfluxListener
import io.github.kjm015.kylenewer.listeners.MessageListener
import net.dv8tion.jda.api.AccountType
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

/**
 * Alright, this is the important file.
 *
 * This is where the application gets ran, and where all of the commands are imported.
 * This is where all of the beans are created and where the settings for each instance of the
 * bot are put into place.
 *
 * If your code adds a command, DON'T FORGET TO ADD IT HERE BEFORE YOU PUSH IT!
 *
 * @author kjm015
 * @since 7/26/2018
 */
@SpringBootApplication
class KyleNewerApplication {

    @Autowired
    private lateinit var settings: DiscordSettings

    @Autowired
    private lateinit var storyCommand: StoryCommand

    @Autowired
    private lateinit var fetchCommand: FetchCommand

    @Autowired
    private lateinit var adviceCommand: AdviceCommand

    @Autowired
    private lateinit var dieCommand: DieCommand

    @Autowired
    private lateinit var rageCommand: RageCommand

    @Autowired
    private lateinit var judgeCommand: JudgeCommand

    @Autowired
    private lateinit var suckCommand: SuckCommand

    @Autowired
    private lateinit var rambleCommand: RambleCommand

    @Autowired
    private lateinit var quoteCommand: QuoteCommand

    @Autowired
    private lateinit var lyricsCommand: LyricsCommand

    @Bean
    fun lyricsClient(): LyricsClient = LyricsClient()

    @Bean
    fun jda(): JDA {
        // Import values from settings
        val token = settings.oauth
        val owner = settings.owner
        val prefix = settings.prefix

        // We could put this all on one line, but we won't. Don't do it.
        val builder = CommandClientBuilder()

        // Set the bot's prefix (what triggers commands)
        builder.setPrefix(prefix)

        // Add the commands to the running pool (Add yours here!)
        builder.addCommands(
                rageCommand,
                adviceCommand,
                fetchCommand,
                judgeCommand,
                suckCommand,
                rambleCommand,
                quoteCommand,
                storyCommand,
                lyricsCommand,
                dieCommand,
                ComputerCommand()
        )

        // Set the owner of the bot (set in properties)
        builder.setOwnerId(owner)

        // Build the command listener
        val client = builder.build()

        // Build the bot with the given settings and listeners
        return JDABuilder(AccountType.BOT)
                .setToken(token)
                .addEventListeners(client, MessageListener(), ExodusListener(), InfluxListener())
                .build()
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(KyleNewerApplication::class.java, *args)
}
