package io.github.kjm015.kylenewer.commands;

import java.util.Random;

public class MessageGenerator {

    private Random randy = new Random();

    private String[] openers = {"fuck", "murder", "sue", "choke-slam", "kick", "kill", "shoot", "stab", "punch"};

    private String[] exclamations = {"shit", "everlasting fucksmack", "fuck", "ass", "piss", "dildo"};

    private String[] targets = {"Ethan Couch", "the KKK", "Nate", "Gaijin", "the Russians", "those idiots"};

    public String generateMessage() {
        return String.format("I am going to %s the %s out of %s",
                openers[randy.nextInt() % openers.length],
                exclamations[randy.nextInt() % exclamations.length],
                targets[randy.nextInt() % targets.length]
        );
    }

}
