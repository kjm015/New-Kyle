package io.github.kjm015.kylenewer.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import io.github.kjm015.kylenewer.message.MessageGenerator;
import io.github.kjm015.kylenewer.message.MessageModifier;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.core.entities.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This command will make Kyle pass judgement on a specified user, or an unsuspecting
 * person in the channel should he so will it.
 *
 * @author kjm015
 * @since 7/26/2018
 */
@Getter
@Slf4j
public class JudgeCommand extends Command {

    private MessageGenerator generator = new MessageGenerator();

    private MessageModifier modifier = new MessageModifier();

    // Random number generator
    private static final Random RANDY = new Random();

    // Required constructor for all commands
    public JudgeCommand() {
        this.name = "judge";
        this.help = "Kyle will judge a random user, or a specific one if mentioned";
        this.aliases = new String[] {"roast", "berate", "condemn", "castigate", "defame", "criticize"};
        this.arguments = "<user>";

        // how long after this command gets called before it can be called again
        this.cooldown = 20;
    }

    /**
     * This command overrides the abstract method from the Command class.
     * When this command is called, this is the stuff that actually happens.
     *
     * For this class, Kyle will pass a random judgement message that is primarily
     * determined by getting pieces from the MessageGenerator class.
     * {@link io.github.kjm015.kylenewer.message.MessageGenerator}
     *
     * He will also mention a target, which is either randomly selected from the pool
     * of the channels users, or it is matched in the command args themselves.
     *
     * @param event - The instance of the command that got called
     *
     * @author kjm015
     * @since 7/26/2018
     */
    @Override
    protected void execute(CommandEvent event) {
        boolean foundUser = false;
        List<User> users = event.getJDA().getUsers();
        String arg = event.getArgs();

       // Default to a random user in the server
        User target = users.get(RANDY.nextInt(users.size()));

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
        }
        // Special case for smart people!
        else if (target.getName().contains("kjm015")) {
            event.reply(target.getAsMention() + " is pretty good at that coding nonsense");
            event.reply("...but I'm probably still the best. Just saying.");
        } else {
           event.reply(generateJudgement(target));
       }
    }

    /**
     * This method formats the judgement message to be sent to a specific user. The judgement
     * is put together using pieces from MessageGenerator given these preset formats.
     *
     * @param target - The user targeted for judgement that will also be mentioned in the message
     * @return the message String to be sent
     *
     * @author kjm015
     * @since 7/26/2018
     */
    private String generateJudgement(User target) {
        // Make a list of String formats
        List<String> funList = new ArrayList<String>() {{
            add(String.format("Nothing says %s like %s.",
                    target.getAsMention(),
                    generator.derogatoryNoun()
            ));
            add(String.format("%s loves nothing more than %s.",
                    target.getAsMention(),
                    generator.derogatoryNoun()
            ));
            add(String.format("There's nothing that %s cherishes more than %s.",
                    target.getAsMention(),
                    generator.derogatoryNoun()
            ));
            add(String.format("%s is great, but there's nothing better than %s.",
                    target.getAsMention(),
                    generator.derogatoryNoun()
            ));
            add(String.format("I always knew that %s was really just %s in disguise.",
                    target.getAsMention(),
                    generator.derogatoryNoun()
            ));
            add(String.format("%s practically wrote the book on %s.",
                    target.getAsMention(),
                    generator.derogatoryNoun()
            ));
            add(String.format("The only class that %s didn't flunk was %s 101.",
                    target.getAsMention(),
                    generator.derogatoryNoun()
            ));
            add(String.format("%s is just a sad combination of %s and %s.",
                    target.getAsMention(),
                    generator.derogatoryNoun(),
                    generator.derogatoryNoun()
            ));
            add(String.format("Some say %s is a cross between %s and %s",
                    target.getAsMention(),
                    generator.derogatoryNoun(),
                    generator.derogatoryNoun()
            ));
            add(String.format("It is a fact that %s identifies with %s",
                    target.getAsMention(),
                    generator.derogatoryNoun()
            ));
            add(String.format("Some people have spirit animals. %s has %s.",
                    target.getAsMention(),
                    generator.derogatoryNoun()
            ));
            add(String.format("If %s had a million dollars, all of it would go towards %s and %s.",
                    target.getAsMention(),
                    generator.derogatoryNoun(),
                    generator.derogatoryNoun()
            ));
            add(String.format("%s, %s, and %s: the perfect Friday for %s",
                    generator.derogatoryNoun(),
                    generator.derogatoryNoun(),
                    generator.derogatoryNoun(),
                    target.getAsMention()

            ));
            add(String.format("It was %s that inspired %s to found the cult of %s.",
                    generator.derogatoryNoun(),
                    target.getAsMention(),
                    generator.derogatoryNoun()
            ));
            add(String.format("It is wildly debated if %s or %s was the downfall of %s.",
                    generator.derogatoryNoun(),
                    generator.derogatoryNoun(),
                    target.getAsMention()
            ));
            add(String.format("You might suck %s, but at least you are an expert in %s.",
                    target.getAsMention(),
                    generator.derogatoryNoun()
            ));
            add(String.format("Taking comfort in %s is sadly the only thing that %s has left.",
                    generator.derogatoryNoun(),
                    target.getAsMention()
            ));
            add(String.format("Kids, learn from %s: %s is not a valid contraceptive.",
                    target.getAsMention(),
                    generator.derogatoryNoun()
            ));
            add(String.format("%s is a valuable lesson in why we learn from schools, and not from %s.",
                    target.getAsMention(),
                    generator.derogatoryNoun()
            ));
            add(String.format("%s is proof that %s and %s do not go together.",
                    target.getAsMention(),
                    generator.derogatoryNoun(),
                    generator.derogatoryNoun()
            ));
            add(String.format("I'm sorry %s, but %s is not a marketable skill.",
                    target.getAsMention(),
                    generator.derogatoryNoun()
            ));
            add(String.format("All hail %s, master of %s!",
                    target.getAsMention(),
                    generator.derogatoryNoun()
            ));
            add(String.format("Breakfast? No, %s starts the morning off right with %s, %s, and %s.",
                    target.getAsMention(),
                    generator.derogatoryNoun(),
                    generator.derogatoryNoun(),
                    generator.derogatoryNoun()
            ));
            add(String.format("%s could never live alone, not without %s",
                    target.getAsMention(),
                    generator.derogatoryNoun()
            ));
            add(String.format("I despise %s, but I hate %s more.",
                    generator.derogatoryNoun(),
                    target.getAsMention()
            ));
            add(String.format("Legalizing %s will only encourage %s to embrace %s.",
                    generator.derogatoryNoun(),
                    target.getAsMention(),
                    generator.derogatoryNoun()
            ));
            add(String.format("Leave it to %s to ruin the fine American pasttimes of %s and %s.",
                    target.getAsMention(),
                    generator.derogatoryNoun(),
                    generator.derogatoryNoun()
            ));
            add(String.format("Combining %s and %s gives you %s. What a world.",
                    generator.derogatoryNoun(),
                    generator.derogatoryNoun(),
                    target.getAsMention()
            ));
        }};
        // Return a random element from the list of Strings
        return funList.get(RANDY.nextInt(funList.size()));
    }
}
