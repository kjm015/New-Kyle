package io.github.kjm015.kylenewer.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class AdviceCommand extends Command {

    private final Random randy = new Random();

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
    }};

    private static final List<String> tips = new ArrayList<String>() {{
        add("sometimes we just need some genocide.");
        add("realistic battles are the best and you know it.");
        add("what happened in Katrina was some rough shit.");
        add("I'm tired, been at lacrosse practice all fucking day.");
        add("there's an explanation for that. I wouldn't know!");
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

    public AdviceCommand() {
        this.name = "advice";
        this.aliases = new String[]{"elaborate.", "advise.", "advice."};
        this.help = "Kyle will give advice to you.";
    }

    @Override
    protected void execute(CommandEvent event) {
        String reply = String.format("@%s: %s %s",
                event.getMember().getNickname(),
                openings.get(randy.nextInt(openings.size())),
                tips.get(randy.nextInt(tips.size()))
        );
        event.reply(reply);
    }
}
