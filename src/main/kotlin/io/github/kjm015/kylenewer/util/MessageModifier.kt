package io.github.kjm015.kylenewer.util

/**
 * This class converts perspectives of certain sentences. In other words, if a user submits a request
 * to Kyle saying "YOU SUCK!", Kyle should give a response that takes what the user said, but with the
 * pronouns flipped.
 *
 * @author kjm015
 * @since 7/26/2018
 */
class MessageModifier {

    /**
     * Switches the perspectives of certain pronouns in a String (you -> me, yourself -> myself etc.)
     * This is done to make responses to questions more logical.
     *
     * @param string - the String to have its perspective reversed
     * @return the new String with the reversed perspective
     */
    fun switchPerspectives(string: String): String {
        var temp = string

        if (temp.contains("your ") || temp.contains("you ") || temp.contains("yourself ")) {
            temp = temp.replace("your ", "my ")
            temp = temp.replace("you ", "me ")
            temp = temp.replace("yourself", "myself")
        } else {
            temp = temp.replace("I ", "you ")
            temp = temp.replace("me ", "you ")
            temp = temp.replace("my ", "your ")
            temp = temp.replace("myself", "yourself")
            temp = temp.replace("this ", "that ")
        }
        temp = temp.replace("some ", "those ")
        temp = temp.replace("these ", "those ")

        return temp
    }

    /**
     * Removes the word "about" or the phrase "on about" from a String
     * used in very limited circumstances, might consider moving this or deprecating
     *
     * @param string - the String to modify
     * @return the new String without "about"
     */
    fun pruneAbout(string: String): String {
        var temp = string

        temp = temp.replace("about ", "")
        temp = temp.replace("on about ", "")

        return temp
    }

    /**
     * Removes articles (a, an, the) from a String.
     * This is for grammatical purposes in select cases.
     *
     * @param string - the String to be modified (have its articles removed)
     * @return the modified String to be sent back (no articles)
     */
    fun removeArticles(string: String): String {
        var temp = string

        temp = temp.replace("the ", "")
        temp = temp.replace("a ", "")
        temp = temp.replace("an ", "")

        return temp
    }

}