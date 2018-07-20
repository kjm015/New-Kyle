package io.github.kjm015.kylenewer.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import io.github.kjm015.kylenewer.message.MessageGenerator;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class RambleCommand extends Command {

    private static final Random RANDY = new Random();
    private static final int UPPER_BOUND = 5;

    public RambleCommand() {
        this.name = "ramble";
        this.help = "Kyle will ramble about a given topic";
        this.aliases = new String[] {"yammer", "rave", "dote"};
        this.arguments = "<topic>";
    }

    @Override
    protected void execute(CommandEvent event) {
        event.reply(this.generateRamblingNoArgs());
    }

    private String generateRamblingNoArgs() {

        List<String> ramblings = new ArrayList<String>() {{
            add(String.format("Dude, the best part about going to %s is getting to experience %s.",
                    MessageGenerator.location(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("If there's one thing that pisses me off about %s, it's %s.",
                    MessageGenerator.location(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("I've always said that people who mess with %s are the first to end up in %s.",
                    MessageGenerator.derogatoryNoun(),
                    MessageGenerator.location()
            ));
            add(String.format("Sadly, the prospect of %s is not enough to deter people from going to %s.",
                    MessageGenerator.derogatoryNoun(),
                    MessageGenerator.location()
            ));
            add(String.format("Let's all %s on down to %s so we can see what %s is like!",
                    MessageGenerator.motionVerb(),
                    MessageGenerator.location(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("I think we all know that %s is really just %s's version of %s.",
                    MessageGenerator.derogatoryNoun(),
                    MessageGenerator.location(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("My professor says that %s was the birthplace of %s. Fucking astounding.",
                    MessageGenerator.location(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("I have decided to turn away from %s and instead turn to %s.",
                    MessageGenerator.derogatoryNoun(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("The only things that get me through my day are a strong shot of vodka and %s.",
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("I have decided to turn away from %s and instead turn to %s.",
                    MessageGenerator.derogatoryNoun(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("Some times we just need %s.",
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("The best advice comes from guys who are %s. They speak the true-true.",
                    MessageGenerator.derogatoryNoun(),
                    MessageGenerator.derogatoryNoun()
            ));
        }};

        return ramblings.get(RANDY.nextInt(ramblings.size()));
    }
}
