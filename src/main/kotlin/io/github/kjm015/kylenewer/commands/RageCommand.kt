package io.github.kjm015.kylenewer.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import io.github.kjm015.kylenewer.util.MessageGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * This command makes Kyle rant and rage about something that he would much rather
 * not deal with at the current time. It's like, super cereal, guys.
 *
 * @author kjm015
 * @since 7/26/2018
 */
@Component
class RageCommand : Command() {

    @Autowired
    private lateinit var generator: MessageGenerator

    // Required constructor for all commands
    init {
        this.name = "rage"
        this.aliases = arrayOf("rant.", "rage.")
        this.help = "Kyle will say something in anger"
        this.guildOnly = false
    }

    /**
     * The actual things that happen when this command gets run.
     * In this instance, Kyle replies with a very angry util.
     *
     * @param event - the command instance
     *
     * @since 7/26/2018
     */
    public override fun execute(event: CommandEvent) {
        event.reply("${generator.intent()} ${generator.openers()} the ${generator.exclamations()} out of ${generator.targets()}")
        event.reply(generator.closer())
    }

}
