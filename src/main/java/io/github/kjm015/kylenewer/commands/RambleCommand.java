package io.github.kjm015.kylenewer.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import lombok.extern.slf4j.Slf4j;

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

        }
    }
}
