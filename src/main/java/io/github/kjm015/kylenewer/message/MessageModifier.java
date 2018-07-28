package io.github.kjm015.kylenewer.message;

import org.springframework.stereotype.Component;

@Component
public class MessageModifier {

	/**
	 * Switches the perspectives of certain pronouns in a String (you -> me, yourself -> myself etc.)
	 * This is done to make responses to questions more logical.
	 *
	 * @param string - the String to have its perspective reversed
	 * @return the new String with the reversed perspective
	 * @author kjm015
	 * @since 7/26/2018
	 */
	public String switchPerspectives(String string) {
		String temp = string;

		if (temp.contains("your ") || temp.contains("you ") || temp.contains("yourself ")) {
			temp = temp.replace("your ", "my ");
			temp = temp.replace("you ", "me ");
			temp = temp.replace("yourself", "myself");
		} else {
			temp = temp.replace("I ", "you ");
			temp = temp.replace("me ", "you ");
			temp = temp.replace("my ", "your ");
			temp = temp.replace("myself", "yourself");
			temp = temp.replace("this ", "that ");
		}
		temp = temp.replace("some ", "those ");
		temp = temp.replace("these ", "those ");

		return temp;
	}

	/**
	 * Removes the word "about" or the phrase "on about" from a String
	 * used in very limited circumstances, might consider moving this or deprecating
	 *
	 * @param string - the String to modify
	 * @return the new String without "about"
	 * @author kjm015
	 * @since 7/26/2018
	 */
	public String pruneAbout(String string) {
		String temp = new String(string);

		temp = temp.replace("about ", "");
		temp = temp.replace("on about ", "");

		return temp;
	}

	/**
	 * Removes articles (a, an, the) from a String.
	 * This is for grammatical purposes in select cases.
	 *
	 * @param string - the String to be modified (have its articles removed)
	 * @return the modified String to be sent back (no articles)
	 * @author kjm015
	 * @since 7/26/2018
	 */
	public String removeArticles(String string) {
		String temp = new String(string);

		temp = temp.replace("the ", "");
		temp = temp.replace("a ", "");
		temp = temp.replace("an ", "");

		return temp;
	}
}
