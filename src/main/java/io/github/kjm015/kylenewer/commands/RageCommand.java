package io.github.kjm015.kylenewer.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import io.github.kjm015.kylenewer.message.MessageGenerator;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Random;

/**
 * This command makes Kyle rant and rage about something that he would much rather
 * not deal with at the current time. It's like, super cereal, guys.
 *
 * @author kjm015
 * @since 7/26/2018
 */
@Getter
public class RageCommand extends Command {

    @Autowired
    private MessageGenerator generator;

    private Random randy = new Random();

    // Exclamations for Kyle to yell
    private ArrayList<String> exc = new ArrayList<String>() {{
        add("shit");
        add("fuck");
        add("ass");
        add("piss");
        add("dick");
        add("balls");
        add("everlasting fucksmack");
    }};

    // Required constructor for all commands
    public RageCommand() {
        this.name = "rage";
        this.aliases = new String[]{"rant.", "rage."};
        this.help = "Kyle will say something in anger";
    }

    /**
     * The actual things that happen when this command gets run.
     * In this instance, Kyle replies with a very angry message.
     *
     * @param event - the command instance
     *
     * @author kjm015
     * @since 7/26/2018
     */
    @Override
    protected void execute(CommandEvent event) {
        event.reply(String.format("%s %s the %s out of %s",
                generator.intent(),
                generator.openers(),
                exc.get(randy.nextInt(exc.size())),
                generator.targets()
        ));

        event.reply(generator.closer());
    }
}
