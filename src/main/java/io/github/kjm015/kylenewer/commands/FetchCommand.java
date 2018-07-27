package io.github.kjm015.kylenewer.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import lombok.Getter;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.User;

import java.util.List;
import java.util.Random;

/**
 * This class makes Kyle fetch some random information about the server or the bot environment.
 * Feel free to add more argument cases for this method, as right now it doesn't really do all
 * that much.
 *
 * @author kjm015
 * @since 7/26/2018
 */
@Getter
public class FetchCommand extends Command {

    // Random number generator
    private static final Random RANDY = new Random();

    // Required constructor for all Commands
    public FetchCommand() {
        this.name = "fetch";
        this.aliases = new String[] {"retrieve", "get", "return"};
        this.help = "Kyle will fetch some server value";
        this.arguments = "<value>";
    }

    /**
     * This command overrides the abstract method from the Command class.
     * When this command is called, this is the stuff that actually happens.
     *
     * For this class, Kyle, will post a message relating to the specific statistic
     * that was requested to be gathered for the server.
     *
     * @param event - The instance of the command that got called
     *
     * @author kjm015
     * @since 7/26/2018
     */
    @Override
    protected void execute(CommandEvent event) {
        String args = event.getArgs();
        JDA jda = event.getJDA();

        // Fetch the ping
        if (args.contains("ping") || args.contains("delay") || args.contains("lag")) { // argument for getting delay for New Kyle
            double pingSec = (double)jda.getPing() / 1000.0;
            event.reply("There's like a " + pingSec + " second delay when I post messages");

            if (pingSec < 0.1) {
                event.reply("Not bad.");
            } else if (pingSec < 0.5) {
                event.reply("Which is kind of shit if you ask me.");
            } else {
                event.reply("Holy fucking shit, that's a lot of lag.");
            }
        }
        // Fetch the number of members in the server
        else if (args.contains("members")) {
            List<User> users = jda.getUsers();

            event.reply("I would guess there are like " + users.size() + " guys in this server.");
        }
        // Don't recognize the command arguments
        else {
            event.replyWarning("No clue what you want from me, dude.");
            event.replyWarning("Like, what is \"" + args +"\" supposed to mean?");
            event.replyWarning("You're giving off some bad ju-ju, man.");
        }
    }

}
