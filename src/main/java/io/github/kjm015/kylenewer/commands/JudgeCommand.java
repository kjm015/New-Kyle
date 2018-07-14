package io.github.kjm015.kylenewer.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import io.github.kjm015.kylenewer.message.MessageGenerator;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.core.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Slf4j
public class JudgeCommand extends Command {

    private static final Random randy = new Random();

    public JudgeCommand() {
        this.name = "judge";
        this.help = "Kyle will judge a random user, or a specific one if mentioned";
        this.aliases = new String[] {"roast", "berate", "condemn", "castigate", "defame", "criticize"};
        this.arguments = "<user>";

        // how long after this command gets called before it can be called again
        this.cooldown = 20;
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
       if (!foundUser && !arg.isEmpty() && !arg.contains("someone") && !arg.contains("somebody")) {
            event.reply("I'm not sure who you're referring to when you say \"" + arg + ",\" but...");
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
           event.reply(generateJudgement(target));
       }
    }

    private String generateJudgement(User target) {
        List<String> funList = new ArrayList<String>() {{
            add(String.format("Nothing says %s like %s.",
                    target.getAsMention(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("%s loves nothing more than %s.",
                    target.getAsMention(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("There's nothing that %s cherishes more than %s.",
                    target.getAsMention(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("%s is great, but there's nothing better than %s.",
                    target.getAsMention(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("I always knew that %s was really just %s in disguise.",
                    target.getAsMention(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("%s practically wrote the book on %s.",
                    target.getAsMention(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("The only class that %s didn't flunk was %s 101.",
                    target.getAsMention(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("%s is just a sad combination of %s and %s.",
                    target.getAsMention(),
                    MessageGenerator.derogatoryNoun(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("Some say %s is a cross between %s and %s",
                    target.getAsMention(),
                    MessageGenerator.derogatoryNoun(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("It is a fact that %s identifies with %s",
                    target.getAsMention(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("Some people have spirit animals. %s has %s.",
                    target.getAsMention(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("If %s had a million dollars, all of it would go towards %s and %s.",
                    target.getAsMention(),
                    MessageGenerator.derogatoryNoun(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("%s, %s, and %s: the perfect Friday for %s",
                    MessageGenerator.derogatoryNoun(),
                    MessageGenerator.derogatoryNoun(),
                    MessageGenerator.derogatoryNoun(),
                    target.getAsMention()

            ));
            add(String.format("It was %s that inspired %s to found the cult of %s.",
                    MessageGenerator.derogatoryNoun(),
                    target.getAsMention(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("It is wildly debated if %s or %s was the downfall of %s.",
                    MessageGenerator.derogatoryNoun(),
                    MessageGenerator.derogatoryNoun(),
                    target.getAsMention()
            ));
            add(String.format("You might suck %s, but at least you are an expert in %s.",
                    target.getAsMention(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("Taking comfort in %s is sadly the only thing that %s has left.",
                    MessageGenerator.derogatoryNoun(),
                    target.getAsMention()
            ));
            add(String.format("Kids, learn from %s: %s is not a valid contraceptive.",
                    target.getAsMention(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("%s is a valuable lesson in why we learn from schools, and not from %s.",
                    target.getAsMention(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("%s is proof that %s and %s do not go together.",
                    target.getAsMention(),
                    MessageGenerator.derogatoryNoun(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("I'm sorry %s, but %s is not a marketable skill.",
                    target.getAsMention(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("All hail %s, master of %s!",
                    target.getAsMention(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("Breakfast? No, %s starts the morning off right with %s, %s, and %s.",
                    target.getAsMention(),
                    MessageGenerator.derogatoryNoun(),
                    MessageGenerator.derogatoryNoun(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("%s could never live alone, not without %s",
                    target.getAsMention(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("I despise %s, but I hate %s more.",
                    MessageGenerator.derogatoryNoun(),
                    target.getAsMention()
            ));
            add(String.format("Legalizing %s will only encourage %s to embrace %s.",
                    MessageGenerator.derogatoryNoun(),
                    target.getAsMention(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("Leave it to %s to ruin the fine American pasttimes of %s and %s.",
                    target.getAsMention(),
                    MessageGenerator.derogatoryNoun(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("Combining %s and %s gives you %s. What a world.",
                    MessageGenerator.derogatoryNoun(),
                    MessageGenerator.derogatoryNoun(),
                    target.getAsMention()
            ));
        }};

        return funList.get(randy.nextInt(funList.size()));
    }
}
