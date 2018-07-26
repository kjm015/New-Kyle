package io.github.kjm015.kylenewer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * This has something to do with the way that the Discord settings relate to Spring beans.
 * Not quite sure what this does. I just know that if you remove it, everything breaks.
 *
 * Don't do it.
 *
 * @since 7/26/2018
 */
@Configuration
@ComponentScan
public class SpringConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}