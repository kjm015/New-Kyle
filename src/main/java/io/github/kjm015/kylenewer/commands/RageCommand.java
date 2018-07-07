package io.github.kjm015.kylenewer.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RageCommand extends Command {

    private Random randy = new Random();

    @Getter
    private final List<String> intents = new ArrayList<String>() {{
        add("I want to");
        add("Someone should seriously");
        add("I should totally");
        add("Just saying, I'll");
        add("I am going to");
        add("Like, I will");
        add("I plan to");
        add("Gonna fucking");
        add("Seriously,");
        add("Why don't I just");
        add("Even my girlfriend says to");
    }
    };

    private String[] openers = {"fuck", "roundhouse kick", "murder", "motherfucking sue", "choke-slam", "drop-kick", "kill", "shoot", "stab", "punch", "murderize", "drop-kick"};

    private String[] exclamations = {"shit", "everlasting fucksmack", "fuck", "ass", "piss", "dick", "balls"};

    private String[] targets = {"Ethan Couch", "Richard Spencer", "Nate", "Gaijin", "the Russians", "you fucking idiots", "Sean Hannity", "Seamus", "these kids"};

    private final List<String> adjuncts =  new ArrayList<String>() {{
        add("Like, who fucking though this was a good idea");
        add("Seriously, where the fuck were you when that happened");
        add("How is that shit allowed to happen");
        add("I am not fucking around");
        add("No one can fucking stop me");
        add("The system is fucking rigged.");
        add("We all know it's bullshit.");
        add("I'm so done with this game's bullshit.");
    }};

    @Getter
    private final List<String> closers = new ArrayList<String>() {{
            add("Not having any of this");
            add("This is so fucking stupid");
            add("You guys are fucking stupid");
            add("I don't give a flying fuck");
            add("Like what the fuck, dude");
            add("Literally the dumbest shit");
            add("I am so fucking done with this");
            add("This is why we need genocide");
            add("Like, god fucking damn it");
            add("We all know it's bullshit.");
            add("I'm so done with this game's bullshit.");
            add("Fucking nobody can be okay with this.");
            add("Like, who fucking though this was a good idea");
            add("Seriously, where the fuck were you when that happened");
            add("How is that shit allowed to happen");
            add("I am not fucking around");
            add("No one can fucking stop me");
            add("The system is fucking rigged.");
            add("We all know it's bullshit.");
            add("I'm so done with this game's bullshit.");
    }};

    public RageCommand() {
        this.name = "rage";
        this.aliases = new String[]{"rant.", "rage."};
        this.help = "Kyle will say something in anger";
    }

    @Override
    protected void execute(CommandEvent event) {
        event.reply(String.format("%s %s the %s out of %s",
                this.getIntents().get(randy.nextInt(intents.size())),
                openers[randy.nextInt(openers.length)],
                exclamations[randy.nextInt(exclamations.length)],
                targets[randy.nextInt(targets.length)]));
        event.reply(this.getClosers().get(randy.nextInt(closers.size())));
    }
}
