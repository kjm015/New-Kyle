package io.github.kjm015.kylenewer.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import io.github.kjm015.kylenewer.util.MessageGenerator
import io.github.kjm015.kylenewer.util.MessageModifier
import lombok.extern.slf4j.Slf4j
import java.util.*

/**
 * This command is to allow Kyle to ramble about whatever is on his mind at any given moment.
 * It usually generates nonsensical garbage, you can add more util templates if you feel like it.
 *
 * @author kjm015
 * @since 7/26/2018
 */
class RambleCommand : Command() {

    private val generator = MessageGenerator()

    private val modifier = MessageModifier()

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
     *
     * @since 7/26/2018
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
     *
     * @since 7/26/2018
     */
    private fun generateRambling(args: String): String {
        val arguments = modifier.pruneAbout(args)

        val ramblings = ArrayList<String>()

        ramblings.add(String.format("Ah, yes: %s. The best way to cope with %s.",
                modifier.switchPerspectives(arguments),
                generator.derogatoryNoun()
        ))
        ramblings.add(String.format("The only thing I can say about %s is the similarity to %s.",
                modifier.switchPerspectives(arguments),
                generator.derogatoryNoun()
        ))
        ramblings.add(String.format("I don't mess with %s. Not since I went to %s.",
                modifier.switchPerspectives(arguments),
                generator.location()
        ))
        ramblings.add(String.format("Only %s can save you from %s.",
                generator.derogatoryNoun(),
                modifier.switchPerspectives(arguments)
        ))
        ramblings.add(String.format("My ex-girlfriend told me about %s. Now she has to deal with %s in %s.",
                modifier.switchPerspectives(arguments),
                generator.derogatoryNoun(),
                generator.location()
        ))

        return ramblings[RANDY.nextInt(ramblings.size)]
    }

    /**
     * Formats a retort based on whatever.
     *
     * @return the formatted response String
     *
     * @since 7/26/2018
     */
    private fun generateRamblingNoArgs(): String {

        val ramblings = object : ArrayList<String>() {
            init {
                add(String.format("Dude, the best part about going to %s is getting to experience %s.",
                        generator.location(),
                        generator.derogatoryNoun()
                ))
                add(String.format("If there's one thing that pisses me off about %s, it's %s.",
                        generator.location(),
                        generator.derogatoryNoun()
                ))
                add(String.format("I've always said that people who mess with %s are the first to end up in %s.",
                        generator.derogatoryNoun(),
                        generator.location()
                ))
                add(String.format("Sadly, the prospect of %s is not enough to deter people from going to %s.",
                        generator.derogatoryNoun(),
                        generator.location()
                ))
                add(String.format("Let's all %s on down to %s so we can see what %s is like!",
                        generator.motionVerb(),
                        generator.location(),
                        generator.derogatoryNoun()
                ))
                add(String.format("I think we all know that %s is really just %s's version of %s.",
                        generator.derogatoryNoun(),
                        generator.location(),
                        generator.derogatoryNoun()
                ))
                add(String.format("My professor says that %s was the birthplace of %s. Fucking astounding.",
                        generator.location(),
                        generator.derogatoryNoun()
                ))
                add(String.format("I have decided to turn away from %s and instead turn to %s.",
                        generator.derogatoryNoun(),
                        generator.derogatoryNoun()
                ))
                add(String.format("The only things that get me through my day are a strong shot of vodka and %s.",
                        generator.derogatoryNoun()
                ))
                add(String.format("I have decided to turn away from %s and instead turn to %s.",
                        generator.derogatoryNoun(),
                        generator.derogatoryNoun()
                ))
                add(String.format("Some times we just need %s.",
                        generator.derogatoryNoun()
                ))
                add(String.format("The best advice comes from guys who are %s. They speak the true-true.",
                        generator.derogatoryNoun(),
                        generator.derogatoryNoun()
                ))
            }
        }

        return ramblings[RANDY.nextInt(ramblings.size)]
    }

    companion object {
        // Random number generator that Tim finds hilarious
        private val RANDY = Random()
    }
}
