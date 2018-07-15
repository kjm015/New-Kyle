package io.github.kjm015.kylenewer.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import io.github.kjm015.kylenewer.message.MessageGenerator;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class SuckCommand extends Command {

    private static final Random randy = new Random();

    public SuckCommand() {
        this.name = "suck";
        this.aliases = new String[] {"lick", "kiss", "fondle"};
        this.help = "Tell Kyle to suck something";
        this.arguments = "<what to suck>";
    }

    @Override
    protected void execute(CommandEvent event) {
        event.reply(event.getAuthor().getAsMention() + " " + this.getRetort(event));
    }

    private String getRetort(CommandEvent event) {
        List<String> locations = new ArrayList<String>() {{
            add(String.format("Yeah, well you can take your %s and %s on over to %s.",
                    MessageGenerator.removeArticles(event.getArgs()),
                    MessageGenerator.motionVerb(),
                    MessageGenerator.location()
            ));
            add(String.format("Sorry, I don't touch the %s of someone who dabbles with %s.",
                    MessageGenerator.removeArticles(event.getArgs()),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("Nice one, I'm sure talking about %s will lead to a promising career at %s.",
                    MessageGenerator.removeArticles(event.getArgs()),
                    MessageGenerator.location()
            ));
        }};

        return locations.get(randy.nextInt(locations.size()));
    }
}
