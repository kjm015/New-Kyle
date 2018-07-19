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
        for (int i = 0; i < RANDY.nextInt(UPPER_BOUND); i++){
            event.reply(this.generateRambling());
        }
    }

    private String generateRambling() {

        List<String> ramblings = new ArrayList<String>() {{
            add(String.format("Dude, the best part about going to %s is getting to experience %s.",
                    MessageGenerator.location(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("If there one thing about %s that pisses me off about %s, it's the %s.",
                    MessageGenerator.location(),
                    MessageGenerator.derogatoryNoun()
            ));
            add(String.format("I've always said that people who mess with %s are the first to end up in %s.",
                    MessageGenerator.derogatoryNoun(),
                    MessageGenerator.location()
            ));
            add(String.format("I am sick of %s, can't they just go to %s?",
                    MessageGenerator.derogatoryNoun(),
                    MessageGenerator.location()
            ));
            add(String.format("Why is there so much %s in %s?",
                    MessageGenerator.derogatoryNoun(),
                    MessageGenerator.location()
            ));
        }};

        return ramblings.get(RANDY.nextInt(ramblings.size()));
    }
}
