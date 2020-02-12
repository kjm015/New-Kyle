package io.github.kjm015.kylenewer.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import io.github.kjm015.kylenewer.util.MessageGenerator
import io.github.kjm015.kylenewer.util.withoutAbout
import io.github.kjm015.kylenewer.util.withReversedPerspective
import org.springframework.stereotype.Component
import java.util.*

/**
 * This command is to allow Kyle to ramble about whatever is on his mind at any given moment.
 * It usually generates nonsensical garbage, you can add more util templates if you feel like it.
 *
 * @author kjm015
 * @since 7/26/2018
 */
@Component
class RambleCommand(private val generator: MessageGenerator) : Command() {

    // Required constructor for all commands
    init {
        this.name = "ramble"
        this.help = "Kyle will ramble about a given topic"
        this.aliases = arrayOf("yammer", "dote")
        this.arguments = "<topic>"
    }

    /**
     * This command overrides the abstract method from the Command class.
     * When this command is called, this is the stuff that actually happens.
     *
     * For this class, Kyle will respond to the command with some absolute garbage util
     * as per the [io.github.kjm015.kylenewer.util.MessageGenerator] class
     *
     * @param event - The instance of the command that got called
     */
    override fun execute(event: CommandEvent) {
        // Give a default response if no arguments are given, otherwise use the arguments in the reply
        if (event.args.isEmpty()) {
            event.reply(this.generateRamblingNoArgs())
        } else {
            event.reply(this.generateRambling(event.args))
        }
    }

    /**
     * Formats a retort based on the stuff that is passed into the command arguments.
     *
     * @param args - the arguments to be passed into the util formatter
     * @return the formatted response String
     */
    private fun generateRambling(args: String): String {
        val arguments = args.withoutAbout()

        val ramblings = ArrayList<String>()
        val sp = arguments.withReversedPerspective()
        val dn = generator.derogatoryNoun()
        val loc = generator.location()

        ramblings.add("Ah, yes: $sp. The best way to cope with $dn.")
        ramblings.add("The only thing I can say about $sp is the similarity to $dn.")
        ramblings.add("I don't deal with $sp. Not since I went to $loc.")
        ramblings.add("The only thing that can save you from $sp is $dn.")
        ramblings.add("My ex-girlfriend told me about $sp. Now she only deals with $dn in $loc.")

        return ramblings.random()
    }

    /**
     * Formats a retort based on whatever.
     *
     * @return the formatted response String
     */
    private fun generateRamblingNoArgs(): String = arrayListOf(
            "Dude, the best part about going to ${generator.location()} is getting to experience ${generator.derogatoryNoun()}.",
            "If there's one thing that pisses me off about ${generator.location()}, it's ${generator.derogatoryNoun()}.",
            "I've always said that the people who mess with ${generator.derogatoryNoun()} are the first to end up in ${generator.location()}.",
            "Sadly, the prospect of ${generator.derogatoryNoun()} is not enough to deter people from going to ${generator.location()}.",
            "Let's ${generator.motionVerb()} on down to ${generator.location()} so that we can see what ${generator.derogatoryNoun()} is like.",
            "I think we all know that ${generator.derogatoryNoun()} is just ${generator.location()}'s version of ${generator.derogatoryNoun()}.",
            "My professor says that ${generator.location()} was the birthplace of ${generator.derogatoryNoun()}. Astounding.",
            "I have decreased my reliance on ${generator.derogatoryNoun()} and instead turned my focus to ${generator.derogatoryNoun()}.",
            "The only things that get me through my day are a strong flask of whiskey and ${generator.derogatoryNoun()}.",
            "Sometimes we just need ${generator.derogatoryNoun()} in our lives, no?",
            "The best advice comes from ${generator.derogatoryNoun()}. They speak the true-true.")
            .random()
}
