package io.github.kjm015.kylenewer.commands

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import io.github.kjm015.kylenewer.message.MessageGenerator
import lombok.extern.slf4j.Slf4j
import net.dv8tion.jda.core.entities.User
import java.util.Random

/**
 * This command will make Kyle pass judgement on a specified user, or an unsuspecting
 * person in the channel should he so will it.
 *
 * @author kjm015
 * @since 7/26/2018
 */
@Slf4j
class JudgeCommand : Command() {

    private val generator = MessageGenerator()

    // Required constructor for all commands
    init {
        this.name = "judge"
        this.help = "Kyle will judge a random user, or a specific one if mentioned"
        this.aliases = arrayOf("roast", "berate", "condemn", "castigate", "defame", "criticize")
        this.arguments = "<user>"

        // how long after this command gets called before it can be called again
        this.cooldown = 20
    }

    /**
     * This command overrides the abstract method from the Command class.
     * When this command is called, this is the stuff that actually happens.
     *
     * For this class, Kyle will pass a random judgement message that is primarily
     * determined by getting pieces from the MessageGenerator class.
     * [io.github.kjm015.kylenewer.message.MessageGenerator]
     *
     * He will also mention a target, which is either randomly selected from the pool
     * of the channels users, or it is matched in the command args themselves.
     *
     * The response hinges upon the arguments coming in, and different judgements
     * are generated for different people.
     *
     * @param event - The instance of the command that got called
     *
     * @author kjm015
     * @since 7/26/2018
     */
    public override fun execute(event: CommandEvent) {
        val arg = event.args

        // Set the user to the sender if they want judgement passed on themselves of the bot
        if ("me".equals(arg, ignoreCase = true)) {
            this.judgeSender(event)
        } else if (arg.contains("yourself")) {
            event.reply("That's an easy one.")
            this.judgeSelf(event)
        } else if (arg.contains("someone") || arg.contains("somebody")) {
            this.judgeRandom(event)
        } else {
            this.judgeTarget(event)
        }
    }

    /**
     * This method generates and sends a judgement for a given target User.
     * If the given user can't be found, judge a random person instead.
     *
     * @param event - the instance of the command being set
     *
     * @author kjm015
     * @since 8/6/2018
     */
    private fun judgeTarget(event: CommandEvent) {
        val users = event.jda.users
        val arg = event.args

        val target = this.getUserFromList(users, arg)

        try {
            if (target != null && target != event.selfUser) {
                event.reply(generator.generateJudgement(target))
            } else if (target == event.selfUser) {
                event.reply("That's a tough one.")
                this.judgeSelf(event)
            } else {
                event.reply("I'm not sure who you're referring to when you say \"$arg,\" but...")
                this.judgeRandom(event)
            }
        } catch (e: NullPointerException) {
            event.reply(String.format("Who the hell is %s?", arg))
        }

    }

    /**
     * This method generates and sends a judgement for a random user in the server
     *
     * @param event - the instance of the command being set
     *
     * @author kjm015
     * @since 8/6/2018
     */
    protected fun judgeRandom(event: CommandEvent) {
        val users = event.jda.users
        val target = users[RANDY.nextInt(users.size)]

        if (target == event.selfUser) {
            event.reply("I'll roast myself, thank you very much.")
            this.judgeSelf(event)
        } else {
            event.reply(generator.generateJudgement(target))
        }
    }

    /**
     * This method will make Kyle reply with a flattering self-assessment
     *
     * @param event - the judge command event coming in to reply to
     *
     * @author kjm015
     * @since 8/5/2018
     */
    protected fun judgeSelf(event: CommandEvent) {
        event.reply("I'm not saying I'm the best person ever, but...")
        event.reply("I totally am.")
    }

    /**
     * This method will make Kyle judge the sender of the command
     *
     * @param event - the judge command event coming in to reply to
     *
     * @since 8/5/2018
     */
    protected fun judgeSender(event: CommandEvent) {
        val target = event.author
        event.reply("If you insist...")
        event.reply(generator.generateJudgement(target))
    }

    /**
     * This method scans a list of users for a selected user with a given discriminator or name.
     *
     * @param users - list of users to be scanned
     * @param discriminatorOrName - the discriminator or name to be scanned against
     * @return the user you're looking for
     *
     * @since 8/5/2018
     */
    private fun getUserFromList(users: List<User>, discriminatorOrName: String): User? {
        var target: User? = null
        for (user in users) {
            if (discriminatorOrName.contains(user.name) || discriminatorOrName.contains(user.discriminator)) {
                target = user
                break
            }
        }
        return target
    }

    companion object {
        private val RANDY = Random()
    }

}
