package io.github.kjm015.kylenewer.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.core.entities.User;

import java.util.List;
import java.util.Random;

@Getter
@Slf4j
public class JudgeCommand extends Command {

    private Random randy = new Random();

    public JudgeCommand() {
        this.name = "judge";
        this.help = "Kyle will judge a random user, or a specific one if mentioned";
        this.aliases = new String[] {"roast", "berate", "condemn", "castigate", "defame", "criticize"};
        this.arguments = "<user>";

        // how long after this command gets called before it can be called again
        this.cooldown = 60;
    }

    @Override
    protected void execute(CommandEvent event) {
        boolean foundUser = false;
        List<User> users = event.getJDA().getUsers();
        String arg = event.getArgs();

       // Default to a random user in the server
        User target = users.get(randy.nextInt(users.size()));

       // Try to get the user that the command sender mentioned, if there is one
        for (User user: users) {
           if (arg.contains(user.getName()) || arg.contains(user.getDiscriminator())) {
               target = user;
               log.debug("User " + user.getName() + " has discriminator of " + user.getDiscriminator());
               foundUser = true;
               break;
           }
       }

       // Set the user to the sender if they want judgement passed on themselves of the bot
       if (("me").equalsIgnoreCase(arg)) {
            foundUser = true;
            target = event.getAuthor();
            event.reply("If you insist...");
       } else if (arg.contains("yourself")) {
            foundUser = true;
            target = event.getSelfUser();
            event.reply("That's an easy one.");
       }

       // If the command sender tried to judge a person that could not be found
       if (!foundUser && !arg.isEmpty()) {
            event.reply("I'm not sure who you're referring to when you say" + arg + ", but...");
       }

       // Pass final judgement
        if (target.equals(event.getSelfUser())) {
            event.reply("I'm not saying I'm the best person ever, but...");
            event.reply("I totally am.");
        } else if (target.getName().contains("kjm015")) {
            event.reply(target.getAsMention() + " is pretty good at that coding nonsense");
            event.reply("...but I'm probably still the best. Just saying.");
        } else {
           // TODO: make this more in-depth
           event.reply(target.getAsMention() + " sucks.");
       }
    }
}
