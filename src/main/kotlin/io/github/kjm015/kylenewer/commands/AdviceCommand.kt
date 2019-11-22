package io.github.kjm015.kylenewer.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
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
class AdviceCommand : Command() {

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
     * [io.github.kjm015.kylenewer.util.MessageGenerator]
     *
     * @param event - The instance of the command that got called
     */
    override fun execute(event: CommandEvent) = if (event.isFromType(ChannelType.TEXT)) {
        event.reply("${event.member.asMention} ${openings.random()} ${tips.random()}")
    } else {
        event.reply("${openings.random()} ${tips.random()}")
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

    // List of tips that Kyle will give to the sender
    private val tips = object : ArrayList<String>() {
        init {
            add("sometimes we just need some genocide.")
            add("realistic battles are the best and you know it.")
            add("what happened in Katrina was some rough shit.")
            add("I'm tired, been at lacrosse practice all fucking day.")
            add("I may not have an explanation for that. Don't look at me.")
            add("Gaijin is the worst fucking company. Fuck the Russians.")
            add("tanks are better than planes, obviously.")
            add("that's what we call \"no bueno\"")
            add("I need food. Be back in a bit.")
            add("I just had the worst fucking day at work.")
            add("nothing's worse than having your son be an invalid.")
            add("we should seriously considering murdering them. Just saying.")
            add("I am not a fucking drag queen.")
            add("something about the Jews.")
            add("you should show them footage of the Allies during WWII.")
            add("I gotta piss real quick.")
            add("my daughter is a fucking horse now.")
            add("my second concubine is pregnant again.")
            add("you don't need to be a Sayyid. It's stupid.")
            add("I may have just become king of Scandinavia.")
            add("I may have just been assassinated by my vassals.")
        }
    }

}