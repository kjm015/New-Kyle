package io.github.kjm015.newkyle.listeners

import io.github.kjm015.newkyle.util.AppConstants
import net.dv8tion.jda.api.entities.ChannelType
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * This class is a listener for when Kyle gets direct messaged or mentioned.
 * Whenever a message is sent in any channel that Kyle can see, this class and the method
 * onMessageReceived get called.
 *
 * @author kjm015
 * @since 1/6/2019
 */
class MessageListener : ListenerAdapter() {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    override fun onMessageReceived(event: MessageReceivedEvent) {

        val msg = event.message.contentDisplay

        super.onMessageReceived(event)

        // Log messages with the channel and sender
        if (event.isFromType(ChannelType.PRIVATE)) {
            log.debug("[PM] ${event.author.name}: $msg\n")
        } else {
            log.debug("[${event.guild.name}][${event.textChannel.name}] ${event.member?.effectiveName ?: ""}: $msg\n")
        }

        // Send a reminder if people ask where Kyle went
        AppConstants.KYLE_LOCATION_QUESTIONS.forEach {
            if (event.message.contentRaw.contains(it, ignoreCase = true)) {
                log.info("\"${event.member!!.effectiveName}\" just asked where Kyle went.")
                event.textChannel.sendMessage("I'm right here, you fucking scrub!").queue()
            }
        }

        if (event.message.contentDisplay.contains(AppConstants.FLAG_TERM_1, ignoreCase = true)) {
            try {
                event.message.delete().reason(AppConstants.DISASTER).queue()
                log.info("Deleted message \"$msg\"")
            } catch (e: Exception) {
                log.warn("Could not delete that user's message! \n $e")
            }

            event.message.channel.sendMessage(AppConstants.DISASTER).queue()

            event.message.channel.sendTyping().queue()

            event.message.channel.sendMessage("This is Felix. Felix is an idiot. Don't be like Felix.").queue()
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