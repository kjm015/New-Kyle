package io.github.kjm015.newkyle.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

/**
 * This class sets the properties for this instance of the Discord bot, stored in the application's
 * property file. I mean, you could store the values in here directly, but that would be stupid.
 *
 * Don't do it.
 *
 * @author kjm015
 * @since 7/26/2018
 */
@Configuration
@ConfigurationProperties(prefix = "discord")
@PropertySource("classpath:discord.properties")
class DiscordSettings {

  var oauth: String? = null

  var game: String = "War Thunder"

  var owner: String? = null

  var prefix: String = "Hey Kyle,"
}
