package io.github.kjm015.newkyle.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import io.github.kjm015.newkyle.warthunder.WarThunderService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class WarThunderCommand(private val warThunderService: WarThunderService) : Command() {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    init {
        this.name = "WarThunder"
        this.help = "Kyle will retrieve War Thunder statistics for a given player."
        this.aliases = arrayOf("wt", "WT", "warthunder", "War_Thunder", "war_thunder", "w_t", "W_T", "W-T", "WARTHUNDER")
        this.guildOnly = false
        this.arguments = "[player]"
        this.cooldown = 3
    }

    override fun execute(event: CommandEvent) {
        event.channel.sendTyping().queue()

        try {
            val stat = warThunderService.getStatsForPlayer(event.args)
            event.replySuccess(stat.displayStats())
        } catch (e: Exception) {
            log.error("Could not fetch player from WT Service -> \n${e.stackTraceToString()}")
            event.replyError("Sorry, I couldn't find any stats for that player!")
        }
    }
}