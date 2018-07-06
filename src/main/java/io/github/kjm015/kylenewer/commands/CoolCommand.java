package io.github.kjm015.kylenewer.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import java.util.Random;

public class CoolCommand extends Command {

    private Random randy = new Random();

    private String[] openers = {"fuck", "murder", "sue", "choke-slam", "kick", "kill", "shoot", "stab", "punch"};

    private String[] exclamations = {"shit", "everlasting fucksmack", "fuck", "ass", "piss", "dildo"};

    private String[] targets = {"Ethan Couch", "the KKK", "Nate", "Gaijin", "the Russians", "those idiots"};

    public CoolCommand() {
        this.name = "rage";
        this.aliases = new String[]{"how are you?","rant"};
        this.help = "Kyle will say something in anger";
    }

    @Override
    protected void execute(CommandEvent event) {
        event.reply(String.format("I am going to %s the %s out of %s",
                openers[randy.nextInt(openers.length - 1)],
                exclamations[randy.nextInt(exclamations.length - 1)],
                targets[randy.nextInt(targets.length - 1)]));
        event.reply("Not having any of this");
    }
}
