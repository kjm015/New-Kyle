package io.github.kjm015.kylenewer.listeners

import io.github.kjm015.kylenewer.util.AppConstants
import net.dv8tion.jda.core.entities.ChannelType
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import net.dv8tion.jda.core.hooks.ListenerAdapter
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.lang.IllegalStateException

/**
 * This class is a listener for when Kyle gets direct messaged or mentioned.
 * Whenever a message is sent in any channel that Kyle can see, this class and the method
 * onMessageReceived get called.
 *
 * @author kjm015
 * @since 1/6/2019
 */
class MessageListener: ListenerAdapter() {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    override fun onMessageReceived(event: MessageReceivedEvent) {

        val msg = event.message.contentDisplay

        super.onMessageReceived(event)

        // Log messages with the channel and sender
        if (event.isFromType(ChannelType.PRIVATE)) {
            log.debug(String.format("[PM] %s: %s\n", event.author.name, msg))
        } else {
            log.debug(String.format("[%s][%s] %s: %s\n", event.guild.name, event.textChannel.name, event.member.effectiveName, msg))
        }

        // Send a reminder if people ask where Kyle went
        for (string in AppConstants.KYLE_LOCATION_QUESTIONS) {
            if (event.message.contentRaw.contains(string)) {
                log.info(String.format("%s just asked where Kyle went.", event.member.effectiveName))
                event.textChannel.sendMessage("I'm here, you fucking scrub!").queue()
            }
        }

        if (event.message.contentDisplay.contains(AppConstants.FLAG_TERM_1, ignoreCase = true)) {
            try {
                event.message.delete().reason(AppConstants.DISASTER).queue()
                log.info("Deleted message \"$msg\"")
            } catch (e: Exception) {
                log.warn("Could not delete that user's message! \n $e")
            }
        }

        if (event.message.contentDisplay.contains(AppConstants.FLAG_TERM_2, ignoreCase = true)) {
            try {
                event.message.delete().reason("Banned term!").queue()
                log.info("Deleted message \"$msg\"")
            } catch (e: Exception) {
                log.warn("Could not edit that user's message! \n $e")
            }
        }

    }

}