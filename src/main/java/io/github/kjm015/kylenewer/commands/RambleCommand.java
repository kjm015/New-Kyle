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

    public RambleCommand() {
        this.name = "ramble";
        this.help = "Kyle will ramble about a given topic";
        this.aliases = new String[] {"yammer", "dote"};
        this.arguments = "<topic>";
    }

    @Override
    protected void execute(CommandEvent event) {
        // Give a default response if no arguments are given, otherwise use the arguments in the reply
        if (event.getArgs().isEmpty()) {
            event.reply(this.generateRamblingNoArgs());
        } else {
            event.reply(this.generateRambling(event.getArgs()));
        }
    }

    private String generateRambling(String string) {
        String arguments = MessageGenerator.pruneAbout(string);

        List<String> ramblings = new ArrayList<>();

        ramblings.add(String.format("Ah, yes: %s. The best way to cope with %s.",
                MessageGenerator.switchPerspectives(arguments),
                MessageGenerator.derogatoryNoun()
        ));
        ramblings.add(String.format("The only thing I can say about %s is the similarity to %s.",
                MessageGenerator.switchPerspectives(arguments),
                MessageGenerator.derogatoryNoun()
        ));
        ramblings.add(String.format("I don't mess with %s. Not since I went to %s.",
                MessageGenerator.switchPerspectives(arguments),
                MessageGenerator.location()
        ));
        ramblings.add(String.format("Only %s can save you from %s.",
                MessageGenerator.derogatoryNoun(),
                MessageGenerator.switchPerspectives(arguments)
        ));
        ramblings.add(String.format("My ex-girlfriend told me about %s. Now she has to deal with %s in %s.",
                MessageGenerator.switchPerspectives(arguments),
                MessageGenerator.derogatoryNoun(),
                MessageGenerator.location()
        ));

        return ramblings.get(RANDY.nextInt(ramblings.size()));
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
