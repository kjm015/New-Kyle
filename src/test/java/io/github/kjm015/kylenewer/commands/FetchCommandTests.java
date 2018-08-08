package io.github.kjm015.kylenewer.commands;

import com.jagrosh.jdautilities.command.CommandEvent;
import io.github.kjm015.kylenewer.message.MessageGenerator;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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
@RunWith(SpringRunner.class)
public class FetchCommandTests {

	@Mock
	private JDA jda;

	@Mock
	private CommandEvent event;

	@Mock
	private List<User> members = new ArrayList<>();

	@InjectMocks
	private FetchCommand fetchCommand;

	@Test
	public void testExecutionForPingAndLessThan100() {
		Mockito.when(event.getArgs()).thenReturn("ping");
		Mockito.when(event.getJDA()).thenReturn(jda);
		Mockito.when(jda.getPing()).thenReturn((long)54);

		fetchCommand.execute(event);

		String out = String.format("There's like a %s second delay when I post messages", ((double)jda.getPing() / 1000.0));

		Mockito.verify(event).reply(out);
		Mockito.verify(event).reply("Not bad.");
	}

	@Test
	public void testExecutionForPingAndOver100() {
		Mockito.when(event.getArgs()).thenReturn("delay");
		Mockito.when(event.getJDA()).thenReturn(jda);
		Mockito.when(jda.getPing()).thenReturn((long)154);

		fetchCommand.execute(event);

		String out = String.format("There's like a %s second delay when I post messages", ((double)jda.getPing() / 1000.0));

		Mockito.verify(event).reply(out);
		Mockito.verify(event).reply("Which is kind of shit if you ask me.");
	}

	@Test
	public void testExecutionForPingAndOver500() {
		Mockito.when(event.getArgs()).thenReturn("lag");
		Mockito.when(event.getJDA()).thenReturn(jda);
		Mockito.when(jda.getPing()).thenReturn((long)551);

		fetchCommand.execute(event);

		String out = String.format("There's like a %s second delay when I post messages", ((double)jda.getPing() / 1000.0));

		Mockito.verify(event).reply(out);
		Mockito.verify(event).reply("Holy fucking shit, that's a lot of lag.");
	}

	@Test
	public void testExecutionForMemberCount() {
		Mockito.when(event.getArgs()).thenReturn("members");
		Mockito.when(jda.getUsers()).thenReturn(members);
		Mockito.when(event.getJDA()).thenReturn(jda);
		Mockito.when(members.size()).thenReturn(72);

		fetchCommand.execute(event);

		String out = String.format("I would guess there are like %s guys in this server.", members.size());

		Mockito.verify(event).reply(out);
	}

	@Test
	public void testExecutionForGarbageResponse() {
		String garbage = "light-themed IDEs";

		Mockito.when(event.getArgs()).thenReturn(garbage);
		Mockito.when(event.getJDA()).thenReturn(jda);

		fetchCommand.execute(event);

		String out2 = String.format("Like, what is \"%s\" supposed to mean?", garbage);

		Mockito.verify(event).replyWarning("No clue what you want from me, dude.");
		Mockito.verify(event).replyWarning(out2);
		Mockito.verify(event).replyWarning("You're giving off some bad ju-ju, man.");
	}
}
