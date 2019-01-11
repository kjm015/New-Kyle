package io.github.kjm015.kylenewer.listeners

import net.dv8tion.jda.client.events.group.GroupUserLeaveEvent
import net.dv8tion.jda.client.exceptions.VerificationLevelException
import net.dv8tion.jda.core.events.guild.GuildBanEvent
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent
import net.dv8tion.jda.core.exceptions.InsufficientPermissionException
import net.dv8tion.jda.core.hooks.ListenerAdapter
import org.slf4j.Logger
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

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    /**
     * This function occurs when a user leave a chat group. This probably will not be
     * used, since New Kyle's functionality is centered around guilds/servers.
     *
     * @param event - the event where the user leaves the chat group
     */
    override fun onGroupUserLeave(event: GroupUserLeaveEvent) {
        super.onGroupUserLeave(event)

        log.info("${event.user.name} has left a chat group.")
        try {
            event.group.sendMessage("Well, ${event.user.name} left the chat.").queue()
        } catch (e: Exception) {
            log.warn("Something went wrong posting to group chat:\n$e")
        }
    }

    /**
     * This function occurs when a user leaves a guild or server that New Kyle is in. More messages can
     * be added to this function later, as I feel that there is room for a lot of
     * snark and showboating here.
     *
     * @param event - an event where a guild member leaves the guild
     */
    override fun onGuildMemberLeave(event: GuildMemberLeaveEvent) {
        super.onGuildMemberLeave(event)

        log.info("User ${event.member.effectiveName} has left the guild known as \"${event.guild.name}\".")

        try {
            event.guild.getTextChannelById("general")
                    .sendMessage("Bad news, guys. ${event.member.effectiveName}, otherwise known as \"${event.member.nickname}\" has left the server.")
                    .queue()
        } catch (e: NullPointerException) {
            log.warn("Could not post messages to general channel in ${event.guild}:\n$e")
        } catch (e: InsufficientPermissionException) {
            log.warn("New Kyle does not have permission to post in general channel in ${event.guild}:\n$e")
        } catch (e: VerificationLevelException) {
            log.warn("New Kyle does not meet verification requirements in ${event.guild}:\n$e")
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
            event.guild.getTextChannelById("general")
                    .sendMessage("Hey guys, ${event.user.name} just got ban-hammered. Nothing personnel, kid.")
                    .queue()
        } catch (e: NullPointerException) {
            log.warn("General channel in ${event.guild} does not exist:\n$e")
        } catch (e: InsufficientPermissionException) {
            log.warn("New Kyle does not have permission to post in general channel in ${event.guild}:\n$e")
        } catch (e: VerificationLevelException) {
            log.warn("New Kyle does not meet verification requirements in ${event.guild}:\n$e")
        }
    }

}
