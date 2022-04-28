package io.github.kjm015.newkyle.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@ConfigurationProperties(prefix = "reddit")
@PropertySource("classpath:reddit.properties")
class RedditSettings {
    var appId: String = ""
    var secret: String = ""
}
