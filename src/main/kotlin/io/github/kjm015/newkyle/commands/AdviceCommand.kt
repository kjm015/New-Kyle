package io.github.kjm015.newkyle.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import io.github.kjm015.newkyle.util.MessageGenerator
import net.dv8tion.jda.api.entities.ChannelType
import org.springframework.stereotype.Component
import java.util.*

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
        event.reply("${event.member.asMention} ${openings.random()} ${messageGenerator.tips()}")
    } else {
        event.reply("${openings.random()} ${messageGenerator.tips()}")
    }


    // List of opening qualifiers
    private val openings = object : ArrayList<String>() {
        init {
            add("Well, you see")
            add("Ah, well")
            add("Yeah, well")
            add("I say that")
            add("I would say")
            add("You should know that")
            add("My girlfriend says")
            add("Realize that")
            add("Some would argue that")
            add("See, I would tell them that")
            add("I've heard that")
            add("Mike used to say that")
            add("My dad's a lawyer, and he told me that")
            add("Tough call, but")
            add("That's a doozy, but")
            add("You speak the true-true, and")
            add("Don't be alarmed, but")
            add("I'm not a fan of Hitler, but")
            add("So don't look, but")
            add("I know you just started, but")
            add("My advisers are all saying that")
            add("My game is glitching, and")
            add("My problem is that")
            add("Don't ask why, but")
        }
    }
}
