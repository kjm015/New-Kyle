package io.github.kjm015.kylenewer.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import lombok.Getter;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

@Getter
public class FetchCommand extends Command {

    @Autowired
    private Random randy;

    public FetchCommand() {
        this.name = "fetch";
        this.aliases = new String[] {"retrieve", "get", "return"};
        this.help = "Kyle will fetch some server value";
        this.arguments = "the thing to fetch";
    }

    @Override
    protected void execute(CommandEvent event) {
        String args = event.getArgs();
        JDA jda = event.getJDA();

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
        } else if (args.contains("members")) {
            List<User> users = jda.getUsers();

            event.reply("I would guess there are like " + users.size() + " guys in this server.");
        }
        else {
            event.replyWarning("No clue what you want from me, dude.");
            event.replyWarning("Like, what is \"" + args +"\" supposed to mean?");
            event.replyWarning("You're giving off some bad ju-ju, man.");
        }
    }

}
