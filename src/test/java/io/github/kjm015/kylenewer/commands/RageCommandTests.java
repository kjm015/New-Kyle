package io.github.kjm015.kylenewer.commands;

import com.jagrosh.jdautilities.command.CommandEvent;
import io.github.kjm015.kylenewer.message.MessageGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Integration test class for the RageCommand class. Tests execution of the command and checks to see that its output
 * is correctly formatted.
 *
 * @author kjm015
 * @since 7/30/2018
 */
@RunWith(SpringRunner.class)
public class RageCommandTests {

	@Mock
	private CommandEvent event;

	@Mock
	private MessageGenerator generator;

	@InjectMocks
	private RageCommand rageCommand;

	@Test
	public void testExecution()
	{
		final String something = "something";

		Mockito.when(generator.intent()).thenReturn(something);

		Mockito.when(generator.openers()).thenReturn(something);

		Mockito.when(generator.targets()).thenReturn(something);

		Mockito.when(generator.exclamations()).thenReturn(something);

		Mockito.when(generator.closer()).thenReturn(something);

		final String out = String.format("%s %s the %s out of %s", something, something, something, something);

		rageCommand.execute(event);

		Mockito.verify(event).reply(out);
		Mockito.verify(event).reply(something);
	}
}
