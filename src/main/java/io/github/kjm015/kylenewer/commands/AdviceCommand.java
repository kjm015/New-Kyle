package io.github.kjm015.kylenewer.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This command will let Kyle give you advice should you ask for it.
 * Again, it's mostly utter garbage. It's the thought that counts.
 *
 * @author kjm015
 * @since 7/26/2018
 */
@Getter
public class AdviceCommand extends Command {

    // Nemo was here

    // Random number generator
    private static final Random RANDY = new Random();

    // List of opening qualifiers
    private static final List<String> openings = new ArrayList<String>() {{
       add("Well, you see");
       add("Ah, well");
       add("Yeah, well");
       add("I say that");
       add("I would say");
       add("You should know that");
       add("My girlfriend says");
       add("Realize that");
       add("Some would argue that");
       add("See, I would tell them that");
       add("I've heard that");
       add("Mike used to say that");
       add("My dad's a lawyer, and he told me that");
       add("Tough call, but");
       add("That's a doozy, but");
       add("You speak the true-true, and");
       add("Don't be alarmed, but");
       add("I'm not a fan of Hitler, but");
       add("So don't look, but");
       add("I know you just started, but");
       add("My advisers are all saying that");
       add("My game is glitching, and");
       add("My problem is that");
       add("Don't ask why, but");
    }};

    // List of tips that Kyle will give to the sender
    private static final List<String> tips = new ArrayList<String>() {{
        add("sometimes we just need some genocide.");
        add("realistic battles are the best and you know it.");
        add("what happened in Katrina was some rough shit.");
        add("I'm tired, been at lacrosse practice all fucking day.");
        add("I may not have an explanation for that. Don't look at me.");
        add("Gaijin is the worst fucking company. Fuck the Russians.");
        add("tanks are better than planes, obviously.");
        add("that's what we call \"no bueno\"");
        add("I need food. Be back in a bit.");
        add("I just had the worst fucking day at work.");
        add("nothing's worse than having your son be an invalid.");
        add("we should seriously considering murdering them. Just saying.");
        add("I am not a fucking drag queen.");
        add("something about the Jews.");
        add("you should show them footage of the Allies during WWII.");
        add("I gotta piss real quick.");
        add("my daughter is a fucking horse now.");
        add("my second concubine is pregnant again.");
        add("you don't need to be a Sayyid. It's stupid.");
        add("I may have just become king of Scandinavia.");
        add("I may have just been assassinated by my vassals.");
    }};

    // Required constructor for every command
    public AdviceCommand() {
        this.name = "advice";
        this.aliases = new String[]{"elaborate.", "advise.", "advice."};
        this.help = "Kyle will give advice to you.";
    }

    /**
     * This command overrides the abstract method from the Command class.
     * When this command is called, this is the stuff that actually happens.
     *
     * For this class, Kyle gives advices that is formatted based on things from
     * both this class and the MessageGenerator class
     * {@link io.github.kjm015.kylenewer.message.MessageGenerator}
     *
     * @param event - The instance of the command that got called
     *
     * @author kjm015
     * @since 7/26/2018
     */
    @Override
    protected void execute(CommandEvent event) {
        String reply = String.format("%s: %s %s",
                event.getMember().getAsMention(),
                openings.get(RANDY.nextInt(openings.size())),
                tips.get(RANDY.nextInt(tips.size()))
        );
        event.reply(reply);
    }
}
