package io.github.kjm015.newkyle.commands

import com.jagrosh.jdautilities.command.CommandEvent
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.entities.User
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.test.context.junit4.SpringRunner
import java.util.*

/**
 * Integration test class for the FetchCommand class. Tests execution of the command and checks to see that its output
 * is correctly formatted, and the output is within the bounds of reason.
 *
 * There are a lot of test cases for this class because of the way this command is set up. Perhaps we should
 * restructure this command in the future?
 *
 * @author kjm015
 * @since 7/30/2018
 */
@RunWith(SpringRunner::class)
class FetchCommandTests {

    @Mock
    private val jda: JDA? = null

    @Mock
    private val event: CommandEvent? = null

    @Mock
    private val members = ArrayList<User>()

    @InjectMocks
    private val fetchCommand: FetchCommand? = null

    @Test
    fun testExecutionForPingAndLessThan100() {
        Mockito.`when`(event!!.args).thenReturn("ping")
        Mockito.`when`(event.jda).thenReturn(jda)
        Mockito.`when`(jda!!.gatewayPing).thenReturn(54.toLong())

        fetchCommand!!.execute(event)

        val out = String.format("There's like a %s second delay when I post messages", jda.gatewayPing.toDouble() / 1000.0)

        Mockito.verify(event).reply(out)
        Mockito.verify(event).reply("Not bad.")
    }

    @Test
    fun testExecutionForPingAndOver100() {
        Mockito.`when`(event!!.args).thenReturn("delay")
        Mockito.`when`(event.jda).thenReturn(jda)
        Mockito.`when`(jda!!.gatewayPing).thenReturn(154.toLong())

        fetchCommand!!.execute(event)

        val out = String.format("There's like a %s second delay when I post messages", jda.gatewayPing.toDouble() / 1000.0)

        Mockito.verify(event).reply(out)
        Mockito.verify(event).reply("Which is kind of shit if you ask me.")
    }

    @Test
    fun testExecutionForPingAndOver500() {
        Mockito.`when`(event!!.args).thenReturn("lag")
        Mockito.`when`(event.jda).thenReturn(jda)
        Mockito.`when`(jda!!.gatewayPing).thenReturn(551.toLong())

        fetchCommand!!.execute(event)

        val out = String.format("There's like a %s second delay when I post messages", jda.gatewayPing.toDouble() / 1000.0)

        Mockito.verify(event).reply(out)
        Mockito.verify(event).reply("Holy fucking shit, that's a lot of lag.")
    }

    @Test
    fun testExecutionForMemberCount() {
        Mockito.`when`(event!!.args).thenReturn("members")
        Mockito.`when`(jda!!.users).thenReturn(members)
        Mockito.`when`(event.jda).thenReturn(jda)
        Mockito.`when`(members.size).thenReturn(72)

        fetchCommand!!.execute(event)

        val out = String.format("I would guess there are like %s guys in this server.", members.size)

        Mockito.verify(event).reply(out)
    }

    @Test
    fun testExecutionForGarbageResponse() {
        val garbage = "light-themed IDEs"

        Mockito.`when`(event!!.args).thenReturn(garbage)
        Mockito.`when`(event.jda).thenReturn(jda)

        fetchCommand!!.execute(event)

        val out2 = String.format("Like, what is \"%s\" supposed to mean?", garbage)

        Mockito.verify(event).replyWarning("No clue what you want from me, dude.")
        Mockito.verify(event).replyWarning(out2)
        Mockito.verify(event).replyWarning("You're giving off some bad ju-ju, man.")
    }
}
