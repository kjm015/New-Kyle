package io.github.kjm015.kylenewer.message

import java.util.*

class SkyrimQuotes {

    var randy = Random()

    fun getQuote(): String {
        var quotes: ArrayList<String> = ArrayList()

        quotes.add("I've heard about you and your honeyed words.")
        quotes.add("Hands to yourself, sneak-thief.")
        quotes.add("Let me guess, someone stole your sweet roll.")

        return quotes[randy.nextInt(quotes.size)]
    }
}