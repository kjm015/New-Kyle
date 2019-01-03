package io.github.kjm015.kylenewer;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import io.github.kjm015.kylenewer.commands.*;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.security.auth.login.LoginException;

/**
 * Alright, this is the important file.
 * <p>
 * This is where the application gets ran, and where all of the commands are imported.
 * This is where all of the beans are created and where the settings for each instance of the
 * bot are put into place.
 * <p>
 * If your code adds a command, DON'T FORGET TO ADD IT HERE BEFORE YOU PUSH IT!
 *
 * @author kjm015
 * @since 7/26/2018
 */
@SpringBootApplication
@Slf4j
public class KyleNewerApplication {

	/**
	 * The head honcho method! This is the main method that runs the whole application.
	 * It also applies the settings to the application before it runs, giving it, you know,
	 * functionality.
	 *
	 * @param args - a dummy argument that makes it so that main isn't an integer anymore (yay!)
	 * @throws LoginException           - you don't have the right credentials, you dingus
	 * @throws IllegalArgumentException - stop sending my application garbage responses
	 * @author kjm015
	 * @since 7/26/2018
	 */
	public static void main(String[] args) throws LoginException, IllegalArgumentException {

		// That Spring thing I was talking about earlier ¯\_(ツ)_/¯
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		DiscordSettings settings = applicationContext.getBean(DiscordSettings.class);

		// Import values from settings
		String token = settings.getOauth();
		String game = settings.getGame();
		String owner = settings.getOwner();

		// We could put this all on one line, but we won't. Don't do it.
		CommandClientBuilder builder = new CommandClientBuilder();

		// Set the bot's prefix (what triggers commands)
		builder.setPrefix("Hey Kyle, ");

		// Add the commands to the running pool (Add yours here!)
		builder.addCommand(new RageCommand());
		builder.addCommand(new AdviceCommand());
		builder.addCommand(new FetchCommand());
		builder.addCommand(new JudgeCommand());
		builder.addCommand(new SuckCommand());
		builder.addCommand(new RambleCommand());
		builder.addCommand(new QuoteCommand());
		builder.addCommand(new StoryCommand());

		// Set the owner of the bot (set in properties)
		builder.setOwnerId(owner);

		// Build the command listener
		CommandClient client = builder.build();

		// Build the bot with the given settings
		new JDABuilder(AccountType.BOT)
				.setGame(Game.watching(game))
				.setToken(token)
				.addEventListener(client)
				.buildAsync();

		// Run the application that hosts the bot
		SpringApplication.run(KyleNewerApplication.class, args);
		log.info("App now running!");
	}

}
