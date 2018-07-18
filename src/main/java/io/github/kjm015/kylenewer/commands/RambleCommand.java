package io.github.kjm015.kylenewer.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import java.util.Random;

public class RambleCommand extends Command {

    private static final Random randy = new Random();

    public RambleCommand() {
        this.name = "ramble";
        this.help = "Kyle will ramble about a given topic";
        this.aliases = new String[] {"yammer", "rave", "dote"};
        this.arguments = "<topic>";
    }

    @Override
    protected void execute(CommandEvent event) {

    }
}
