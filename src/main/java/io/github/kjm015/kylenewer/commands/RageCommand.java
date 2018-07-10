package io.github.kjm015.kylenewer.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class RageCommand extends Command {

    private Random randy = new Random();

    private static final List<String> intents = new ArrayList<String>() {{
        add("I want to");
        add("Someone should seriously");
        add("I should totally");
        add("Just saying, I'll");
        add("I am going to");
        add("Like, I will");
        add("I'm considering calling someone to");
        add("I plan to");
        add("Gonna fucking");
        add("I should get my dad to");
        add("Seriously,");
        add("Why don't I just");
        add("Even my girlfriend says to");
        add("I know some guys that would");
    }};

    private static final List<String> open = new ArrayList<String>() {{
       add("fuck");
       add("invade");
       add("roundhouse kick");
       add("shoot");
       add("motherfucking sue");
       add("curb stomp");
       add("choke slam");
       add("drop kick");
       add("kill");
       add("murder");
       add("dick punch");
       add("stab");
       add("hack");
       add("exterminate");
       add("gas");
       add("protest");
       add("run over");
       add("sue");
       add("vandalize");
    }};

    private static final List<String> target = new ArrayList<String>() {{
        add("Ethan Couch");
        add("Mike Pence");
        add("Trump");
        add("Nate");
        add("Gaijin");
        add("the Russians");
        add("these Chinese hackers");
        add("you fucking idiots");
        add("Richard Spencer");
        add("these kids");
        add("the alt-right");
        add("my boss");
        add("the police");
        add("that guy Seamus");
        add("the Mamluks");
        add("the Pope");
        add("Hitler");
        add("Nazis");
        add("stupid people");
    }};

    private String[] exclamations = {"shit", "everlasting fucksmack", "fuck", "ass", "piss", "dick", "balls"};

    private static final List<String> adjuncts =  new ArrayList<String>() {{
        add("Like, who fucking though this was a good idea");
        add("Seriously, where the fuck were you when that happened");
        add("How is that shit allowed to happen");
        add("I am not fucking around");
        add("No one can fucking stop me");
        add("The system is fucking rigged.");
        add("We all know it's bullshit.");
        add("I'm so done with this game's bullshit.");
        add("Like, I can't fucking stand this shit anymore.");
    }};

    private static final List<String> closers = new ArrayList<String>() {{
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
                intents.get(randy.nextInt(intents.size())),
                open.get(randy.nextInt(open.size())),
                exclamations[randy.nextInt(exclamations.length)],
                target.get(randy.nextInt(target.size())))
        );
        event.reply(closers.get(randy.nextInt(closers.size())));
    }
}
