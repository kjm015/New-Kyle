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
        this.arguments = "The user to berate";
        this.cooldown = 60; // how long after this command gets called before it can be called again
    }

    @Override
    protected void execute(CommandEvent event) {
       List<User> users = event.getJDA().getUsers();

       // Default to a random user in the server
       User target = users.get(randy.nextInt(users.size()));

       // Try to get the user that the command sender mentioned, if there is one
       for (User user: users) {
           if (event.getArgs().contains(user.getName()) || event.getArgs().contains(user.getDiscriminator())) {
               target = user;
               log.info("User " + user.getName() + " has discriminator of " + user.getDiscriminator());
               break;
           }
       }

       // Pass final judgement
       if (target.equals(event.getSelfUser())) {
           event.reply("I'm the best fucking person ever");
       } else {
           // TODO: make this more in-depth
           event.reply(target.getAsMention() + " sucks.");
       }
    }
}