package io.github.kjm015.kylenewer

import com.jagrosh.jdautilities.command.CommandClientBuilder
import io.github.kjm015.kylenewer.commands.*
import io.github.kjm015.kylenewer.listeners.ExodusListener
import io.github.kjm015.kylenewer.listeners.InfluxListener
import io.github.kjm015.kylenewer.listeners.MessageListener
import net.dv8tion.jda.core.AccountType
import net.dv8tion.jda.core.JDABuilder
import net.dv8tion.jda.core.entities.Game
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.AnnotationConfigApplicationContext

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

    companion object {
        private val log: Logger = LoggerFactory.getLogger(this::class.java)

        /**
         * The head honcho method! This is the main method that runs the whole application.
         * It also applies the settings to the application before it runs, giving it, you know,
         * functionality.
         *
         * @param args - a dummy argument that makes it so that main isn't an integer like C++
         */
        @JvmStatic
        fun main(args: Array<String>) {

            // That Spring thing I was talking about earlier ¯\_(ツ)_/¯
            val applicationContext = AnnotationConfigApplicationContext(SpringConfiguration::class.java)
            val settings = applicationContext.getBean(DiscordSettings::class.java)

            // Import values from settings
            val token = settings.oauth
            val game = settings.game
            val owner = settings.owner

            // We could put this all on one line, but we won't. Don't do it.
            val builder = CommandClientBuilder()

            // Set the bot's prefix (what triggers commands)
            builder.setPrefix("Hey Kyle, ")

            // Add the commands to the running pool (Add yours here!)
            builder.addCommand(RageCommand())
            builder.addCommand(AdviceCommand())
            builder.addCommand(FetchCommand())
            builder.addCommand(JudgeCommand())
            builder.addCommand(SuckCommand())
            builder.addCommand(RambleCommand())
            builder.addCommand(QuoteCommand())
            builder.addCommand(StoryCommand())

            // Set the owner of the bot (set in properties)
            builder.setOwnerId(owner)

            // Build the command listener
            val client = builder.build()

            // Build the bot with the given settings and listeners
            JDABuilder(AccountType.BOT)
                    .setGame(Game.watching(game))
                    .setToken(token)
                    .addEventListener(client)
                    .addEventListener(MessageListener())
                    .addEventListener(ExodusListener())
                    .addEventListener(InfluxListener())
                    .buildAsync()

            // Run the application that hosts the bot
            SpringApplication.run(KyleNewerApplication::class.java, *args)
            log.info("App now running!")
        }
    }

}
