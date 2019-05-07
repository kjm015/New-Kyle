package io.github.kjm015.kylenewer.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import java.util.*

/**
 * This command will let Kyle probably not die
 * Again, it's mostly utter garbage. It's the thought that counts.
 *
 * @author tdickens1234
 * @since 7/26/2018
 */

class DieCommand : Command() {
    // Required constructor for every command
    init {
        this.name = "die"
        this.aliases = arrayOf("kill.")
        this.help = "Kyle will probably not die."
    }

    /**
     * This command overrides the abstract method from the Command class.
     * When this command is called, this is the stuff that actually happens.
     *
     *
     * For this class, Kyle executes the die command, which for now, does not much
     * [io.github.kjm015.kylenewer.util.MessageGenerator]
     *
     * @param event - The instance of the command that got called
     */
    override fun execute(event: CommandEvent) {
        val reply = String.format("%s: %s %s",
                event.member.asMention,
                openings[RANDY.nextInt(openings.size)],
                tips[RANDY.nextInt(tips.size)]
        )
        event.reply(reply)
    }

    companion object {
        // Random number generator
        private val RANDY = Random()

        // List of opening qualifiers
        private val openings = object : ArrayList<String>() {
            init {
                add("That's my secret. I'm always angry.")
                add("To die, to sleep – to sleep, perchance to dream – ay, there's the rub, for in this sleep of death what dreams may come… \n")
                add("I will commit sudoku... \n")
            }
        }
        // List of tips that Kyle will give to the sender
        private val tips = object : ArrayList<String>() {
            init {
                add("on ur mom")
                add("1234567890!!!!!!!!!")
                add("Wait, what the fuck did you just fucking say about me, you little bitch? I'll have you know I graduated top of my class in the Navy Seals, and I've been involved in numerous secret raids on Al-Quaeda, and I have over 300 confirmed kills. I am trained in gorilla warfare and I'm the top sniper in the entire US armed forces. You are nothing to me but just another target. I will wipe you the fuck out with precision the likes of which has never been seen before on this Earth, mark my fucking words. You think you can get away with saying that shit to me over the Internet? Think again, fucker. As we speak I am contacting my secret network of spies across the USA and your IP is being traced right now so you better prepare for the storm, maggot. The storm that wipes out the pathetic little thing you call your life. You're fucking dead, kid. I can be anywhere, anytime, and I can kill you in over seven hundred ways, and that's just with my bare hands. Not only am I extensively trained in unarmed combat, but I have access to the entire arsenal of the United States Marine Corps and I will use it to its full extent to wipe your miserable ass off the face of the continent, you little shit. If only you could have known what unholy retribution your little \"clever\" comment was about to bring down upon you, maybe you would have held your fucking tongue. But you couldn't, you didn't, and now you're paying the price, you goddamn idiot. I will shit fury all over you and you will drown in it. You're fucking dead, kiddo.")
            }
        }
    }
}