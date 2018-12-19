package io.github.kjm015.kylenewer.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import io.github.kjm015.kylenewer.message.SkyrimQuotes;

public class SkyrimCommand extends Command {

	private SkyrimQuotes quotes = new SkyrimQuotes();

	public SkyrimCommand() {
		this.hidden = true;
		this.name = "Skyrim";
	}

	@Override
	protected void execute(CommandEvent event) {
		event.reply(quotes.getQuote());
	}

}
