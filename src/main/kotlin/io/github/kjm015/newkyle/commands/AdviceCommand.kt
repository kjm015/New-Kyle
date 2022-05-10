package io.github.kjm015.newkyle.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import io.github.kjm015.newkyle.util.MessageGenerator
import net.dv8tion.jda.api.entities.ChannelType
import org.springframework.stereotype.Component

/**
 * This command will let Kyle give you advice should you ask for it.
 * Again, it's mostly utter garbage. It's the thought that counts.
 *
 * @author kjm015
 * @since 7/26/2018
 */
@Component
class AdviceCommand(private val messageGenerator: MessageGenerator) : Command() {

    // Required constructor for every command
    init {
        this.name = "advice"
        this.aliases = arrayOf("elaborate.", "advise.", "advice.")
        this.help = "Kyle will give advice to you."
        this.guildOnly = false
    }

    /**
     * This command overrides the abstract method from the Command class.
     * When this command is called, this is the stuff that actually happens.
     *
     *
     * For this class, Kyle gives advices that is formatted based on things from
     * both this class and the MessageGenerator class
     * [io.github.kjm015.newkyle.util.MessageGenerator]
     *
     * @param event - The instance of the command that got called
     */
    override fun execute(event: CommandEvent) = if (event.isFromType(ChannelType.TEXT)) {
        event.reply("${event.member.asMention} ${messageGenerator.prefaces()} ${messageGenerator.tips()}")
    } else {
        event.reply("${messageGenerator.prefaces()} ${messageGenerator.tips()}")
    }
}
