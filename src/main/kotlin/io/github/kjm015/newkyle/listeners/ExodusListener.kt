package io.github.kjm015.newkyle.listeners

import net.dv8tion.jda.api.events.guild.GuildBanEvent
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.slf4j.LoggerFactory

/**
 * This class is responsible for listening and responding to events in which users
 * leave a server or group. This can be something that was voluntarily done by said
 * user, or it could be the result of a kick/ban.
 *
 * Kyle's responses will be sent to the "general" channel of whatever guild he is in.
 * It should be noted that if he cannot find said channel, an error will be thrown.
 *
 * @author kjm015
 * @since 01/10/2019
 */
class ExodusListener : ListenerAdapter() {

    private val log = LoggerFactory.getLogger(this.javaClass)

    /**
     * This function occurs when a user leaves a guild or server that New Kyle is in. More messages can
     * be added to this function later, as I feel that there is room for a lot of
     * snark and showboating here.
     *
     * @param event - an event where a guild member leaves the guild
     */
    override fun onGuildMemberRemove(event: GuildMemberRemoveEvent) {
        super.onGuildMemberRemove(event)

        log.info("User ${event.member!!.effectiveName} has left the guild known as \"${event.guild.name}\".")

        try {
            event.guild.getTextChannelById("general")!!
                .sendMessage("Bad news, guys. ${event.member!!.effectiveName}, otherwise known as \"${event.member!!.nickname}\" has left the server.")
                .queue()
        } catch (e: NullPointerException) {
            log.warn("Could not post messages to general channel in ${event.guild}:\n$e")
        } catch (e: InsufficientPermissionException) {
            log.warn("New Kyle does not have permission to post in general channel in ${event.guild}:\n$e")
        }
    }

    /**
     * This function occurs when a user is banned from a server that New Kyle is in.
     * Again, I feel that more snark messages can be added here in the future.
     *
     * @param event - an event where a user gets banned from a server/guild
     */
    override fun onGuildBan(event: GuildBanEvent) {
        super.onGuildBan(event)

        log.info("User ${event.user.name} has been banned from guild \"${event.guild.name}\"")

        try {
            event.guild.getTextChannelById("general")!!
                .sendMessage("Hey guys, ${event.user.name} just got ban-hammered. Nothing personnel, kid.")
                .queue()
        } catch (e: NullPointerException) {
            log.warn("General channel in ${event.guild} does not exist:\n$e")
        } catch (e: InsufficientPermissionException) {
            log.warn("New Kyle does not have permission to post in general channel in ${event.guild}:\n$e")
        }
    }

}
