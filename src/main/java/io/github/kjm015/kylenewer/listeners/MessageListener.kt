package io.github.kjm015.kylenewer.listeners

import net.dv8tion.jda.core.entities.ChannelType
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import net.dv8tion.jda.core.hooks.ListenerAdapter
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class MessageListener: ListenerAdapter() {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    override fun onMessageReceived(event: MessageReceivedEvent) {
        super.onMessageReceived(event)

        if (event.isFromType(ChannelType.PRIVATE)) {
            log.info(String.format("[PM] %s: %s\n", event.author.name, event.message.contentDisplay))
        } else {
            log.info(String.format("[%s][%s] %s: %s\n", event.guild.name, event.textChannel.name,
                    event.member.effectiveName, event.message.contentDisplay))
        }
    }

}