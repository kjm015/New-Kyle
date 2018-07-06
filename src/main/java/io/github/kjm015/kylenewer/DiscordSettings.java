package io.github.kjm015.kylenewer;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@Getter
public class DiscordSettings {

    @Value("${discord.oauth}")
    private String oauth;

    @Value("${discord.game}")
    private String game;

    @Value("${discord.owner}")
    private String owner;

}
