package io.github.kjm015.newkyle.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import io.github.kjm015.newkyle.util.MessageGenerator
import io.github.kjm015.newkyle.util.withReversedPerspective
import org.springframework.stereotype.Component
import java.util.*

/**
 * This command is supposed to respond to requests that Kyle go suck, kiss, or lick something that
 * he is very nonplussed about actually doing.
 *
 * @author kjm015
 * @since 7/26/2018
 */
@Component
class SuckCommand(private val generator: MessageGenerator) : Command() {

    init {
        this.name = "suck"
        this.aliases = arrayOf("lick", "kiss", "fondle")
        this.help = "Tell Kyle to suck something"
        this.arguments = "<what to suck>"
    }

    /**
     * This command overrides the abstract method from the Command class.
     * When this command is called, this is the stuff that actually happens.
     *
     * For this class, Kyle will respond with his reaction to the suck request.
     * Generally, his response will be rather trite as per
     * [io.github.kjm015.newkyle.util.MessageGenerator]
     *
     * @param event - The instance of the command that got called
     */
    override fun execute(event: CommandEvent) = if (event.args.isEmpty() || event.args.contains(" it")) {
        event.reply("I can't do something with a thing that you don't have, dude.")
    } else {
        event.reply(event.author.asMention + " " + this.getRetort(event))
    }

    /**
     * This command generates Kyle's retort based on the arguments that were
     * passed into the command.
     *
     * @param event - the instance of the command that got called
     * @return the retort
     */
    private fun getRetort(event: CommandEvent): String {
        val locations = object : ArrayList<String>() {
            init {
                add("Yeah, well you can take ${event.args.withReversedPerspective()} and ${generator.motionVerb()} over to ${generator.location()}")
                add("Sorry, but ${event.args.withReversedPerspective()} is more suited to ${generator.derogatoryNoun()}.")
                add("Fuck you, I'm sure that talking about ${event.args.withReversedPerspective()} is a promising future.")
            }
        }

        return locations.random()
    }
}
