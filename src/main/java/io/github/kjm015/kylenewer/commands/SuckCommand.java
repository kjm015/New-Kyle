package io.github.kjm015.kylenewer.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class SuckCommand extends Command {

    private static final Random randy = new Random();

    public SuckCommand() {
        this.name = "suck";
        this.aliases = new String[] {"lick", "kiss"};
        this.help = "Tell Kyle to suck something";
        this.arguments = "<what to suck>";
    }

    @Override
    protected void execute(CommandEvent event) {

    }

    private String getRetort() {
        List<String> locations = new ArrayList<String>() {{

        }};

        return locations.get(randy.nextInt(locations.size()));
    }
}
