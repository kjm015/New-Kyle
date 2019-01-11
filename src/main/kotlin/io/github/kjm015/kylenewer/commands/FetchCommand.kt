package io.github.kjm015.kylenewer.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import io.github.kjm015.kylenewer.util.AppConstants
import lombok.Getter

/**
 * This class makes Kyle fetch some random information about the server or the bot environment.
 * Feel free to add more argument cases for this method, as right now it doesn't really do all
 * that much.
 *
 * @author kjm015
 * @since 7/26/2018
 */
@Getter
class FetchCommand : Command() {

    // Required constructor for all Commands
    init {
        this.name = "fetch"
        this.aliases = arrayOf("retrieve", "get", "return", "给我")
        this.help = "Kyle will fetch some server value"
        this.arguments = "<value>"
    }

    /**
     * This command overrides the abstract method from the Command class.
     * When this command is called, this is the stuff that actually happens.
     *
     * For this class, Kyle, will post a util relating to the specific statistic
     * that was requested to be gathered for the server.
     *
     * @param event - The instance of the command that got called
     *
     * @since 7/26/2018
     */
    public override fun execute(event: CommandEvent) {
        val args = event.args
        val jda = event.jda

        // Fetch the ping
        // argument for getting delay for New Kyle
        if (args.contains("ping") || args.contains("delay") || args.contains("lag")) {
            val pingSec = jda.ping.toDouble() / 1000.0
            event.reply("There's like a $pingSec second delay when I post messages")

            when {
                pingSec < 0.1 -> event.reply("Not bad.")
                pingSec < 0.5 -> event.reply("Which is kind of shit if you ask me.")
                else -> event.reply("Holy fucking shit, that's a lot of lag.")
            }
        } else if (args.contains("members")) {
            val users = jda.users

            event.reply("I would guess there are like " + users.size + " guys in this server.")
        } else if (args.contains("controversial") || args.contains("demonetized")) {

            event.reply(AppConstants.DISASTER)

        } else {
            event.replyWarning("No clue what you want from me, dude.")
            event.replyWarning("Like, what is \"$args\" supposed to mean?")
            event.replyWarning("You're giving off some bad ju-ju, man.")
        }// Don't recognize the command arguments
        // Fetch the number of members in the server
    }


}
