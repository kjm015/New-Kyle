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

       // Default to a random user in the server
        User target = users.get(randy.nextInt(users.size()));

       // Try to get the user that the command sender mentioned, if there is one
        for (User user: users) {
           if (event.getArgs().contains(user.getName()) || event.getArgs().contains(user.getDiscriminator())) {
               target = user;
               log.debug("User " + user.getName() + " has discriminator of " + user.getDiscriminator());
               foundUser = true;
               break;
           }
       }

       // If the command sender tried to judge a person that could not be found
       if(!foundUser && !event.getArgs().equals(null)) {
            event.reply("I'm not sure who you're referring to, but...");
       }

       // Pass final judgement
        if (target.equals(event.getSelfUser())) {
            event.reply("I'm not saying I'm the best person ever, but...");
        } else if (target.getName().equalsIgnoreCase("kjm015")) {
            event.reply(target.getAsMention() + " is pretty good at that coding nonsense");
            event.reply("...but I'm probably still the best. Just saying.");
        } else {
           // TODO: make this more in-depth
           event.reply(target.getAsMention() + " sucks.");
       }
    }
}
