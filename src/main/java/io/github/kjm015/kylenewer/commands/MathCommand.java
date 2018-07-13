package io.github.kjm015.kylenewer.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class MathCommand extends Command {

    public calcAdd() {

    }

    public MathCommand() {
        this.name = "add";
        this.aliases = new String[]{"+", "plus", "sum", "summation", "total"};
        this.help = "Kyle will do math.";
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
