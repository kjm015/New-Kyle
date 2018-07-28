package io.github.kjm015.kylenewer.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import io.github.kjm015.kylenewer.message.MessageGenerator;
import io.github.kjm015.kylenewer.message.MessageModifier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This command is supposed to respond to requests that Kyle go suck, kiss, or lick something that
 * he is very nonplussed about actually doing.
 *
 * @author kjm015
 * @since 7/26/2018
 */
@Slf4j
public class SuckCommand extends Command {

    @Autowired
    private MessageGenerator generator;

    @Autowired
    private MessageModifier modifier;

    // Random number generator that Adam finds hilarious
    private static final Random RANDY = new Random();

    // Constructor required for all commands
    public SuckCommand() {
        this.name = "suck";
        this.aliases = new String[] {"lick", "kiss", "fondle"};
        this.help = "Tell Kyle to suck something";
        this.arguments = "<what to suck>";
    }

    /**
     * This command overrides the abstract method from the Command class.
     * When this command is called, this is the stuff that actually happens.
     *
     * For this class, Kyle will respond with his reaction to the suck request.
     * Generally, his response will be rather trite as per
     * {@link io.github.kjm015.kylenewer.message.MessageGenerator}
     *
     * @param event - The instance of the command that got called
     *
     * @author kjm015
     * @since 7/26/2018
     */
    @Override
    protected void execute(CommandEvent event) {
        if (event.getArgs().isEmpty() || event.getArgs().contains(" it")) {
            event.reply("I can't do something with a thing that you don't have, dude.");
        } else {
            event.reply(event.getAuthor().getAsMention() + " " + this.getRetort(event));
        }
    }

    /**
     * This command generates Kyle's retort based on the arguments that were
     * passed into the command.
     *
     * @param event - the instance of the command that got called
     * @return the retort
     *
     * @author kjm015
     * @since 7/26/2018
     */
    private String getRetort(CommandEvent event) {
        List<String> locations = new ArrayList<String>() {{
            add(String.format("Yeah, well you can take your %s and %s on over to %s.",
                    modifier.removeArticles(event.getArgs()),
                    generator.motionVerb(),
                    generator.location()
            ));
            add(String.format("Sorry, I don't touch the %s of someone who dabbles with %s.",
                    modifier.removeArticles(event.getArgs()),
                    generator.derogatoryNoun()
            ));
            add(String.format("Nice one, I'm sure talking about %s will lead to a promising career with %s.",
                    modifier.removeArticles(event.getArgs()),
                    generator.location()
            ));
        }};

        return locations.get(RANDY.nextInt(locations.size()));
    }
}
