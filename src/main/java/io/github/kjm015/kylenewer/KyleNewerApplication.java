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

@SpringBootApplication
@Slf4j
public class KyleNewerApplication {

	public static void main(String[] args) throws LoginException, IllegalArgumentException {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		DiscordSettings settings = applicationContext.getBean(DiscordSettings.class);

		String token = settings.getOauth();
		String game = settings.getGame();
		String owner = settings.getOwner();

		CommandClientBuilder builder = new CommandClientBuilder();
		builder.setPrefix("Hey Kyle, ");

		builder.addCommand(new RageCommand());
		builder.addCommand(new AdviceCommand());
		builder.addCommand(new FetchCommand());
		builder.addCommand(new JudgeCommand());
		builder.addCommand(new SuckCommand());
		builder.addCommand(new RambleCommand());

		builder.setOwnerId(owner);

		CommandClient client = builder.build();

		new JDABuilder(AccountType.BOT)
				.setGame(Game.watching(game))
				.setToken(token)
				.addEventListener(client)
				.buildAsync();

		SpringApplication.run(KyleNewerApplication.class, args);
		log.info("App now running!");
	}
}
