package io.github.kjm015.kylenewer.util

fun String.withArticle(): String {
    return if (
            this.startsWith(prefix = "a", ignoreCase = true) ||
            this.startsWith(prefix = "e", ignoreCase = true) ||
            this.startsWith(prefix = "i", ignoreCase = true) ||
            this.startsWith(prefix = "o", ignoreCase = true) ||
            this.startsWith(prefix = "u", ignoreCase = true)
    )
        "an $this"
    else
        "a $this"
}

/**
 * Removes articles (a, an, the) from a String.
 * This is for grammatical purposes in select cases.
 *
 * @return the modified String to be sent back (no articles)
 */
fun String.withoutArticles(): String =
        this.replace("the ", "").replace("a ", "").replace("an ", "")


/**
 * Switches the perspectives of certain pronouns in a String (you -> me, yourself -> myself etc.)
 * This is done to make responses to questions more logical.
 *
 * @return the new String with the reversed perspective
 */
fun String.withReversedPerspective(): String {
    var temp = this

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
 * @return the new String without "about"
 */
fun String.withoutAbout(): String {
    var temp = this

    temp = temp.replace("about ", "")
    temp = temp.replace("on about ", "")

    return temp
}