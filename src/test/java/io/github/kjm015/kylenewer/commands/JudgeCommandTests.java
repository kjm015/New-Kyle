package io.github.kjm015.kylenewer.commands;

import com.jagrosh.jdautilities.command.CommandEvent;
import io.github.kjm015.kylenewer.message.MessageGenerator;
import net.dv8tion.jda.core.entities.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class JudgeCommandTests {

	@Mock
	private CommandEvent event;

	@Mock
	private MessageGenerator generator;

	@Mock
	private User user;

	@Captor
	private ArgumentCaptor<User> userCaptor;

	@Captor
	private ArgumentCaptor<String> stringCaptor;

	@InjectMocks
	private JudgeCommand judgeCommand;

	@Mock
	private Random randy;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testExecutionForSenderTryingToRoastThemselves() {
		when(event.getArgs()).thenReturn("me");
		when(generator.derogatoryNoun()).thenReturn("derogatory noun");
		when(user.getAsMention()).thenReturn("@user");

		when(generator.generateJudgement(any())).thenReturn("something");

		doNothing().when(event).reply(anyString());

		judgeCommand.execute(event);

		verify(event).reply("If you insist...");
		verify(event).reply("something");
	}

	@Test
	public void testExecutionForAskingKyleToRoastHimself() {
		when(event.getArgs()).thenReturn("yourself");
		doNothing().when(event).reply(anyString());

		judgeCommand.execute(event);

		Mockito.verify(event).reply("That's an easy one.");
		Mockito.verify(event).reply("I'm not saying I'm the best person ever, but...");
		Mockito.verify(event).reply("I totally am.");
	}

}
