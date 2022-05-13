package io.github.kjm015.newkyle.util

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component
import org.springframework.util.ResourceUtils

/**
 * This class generates pulls quotes from a JSON file
 * @author kjm015
 * @since 01/20/2019
 */
@Component
class QuotesService {

    private val quoteList: List<Quote>

    init {
        val url = ResourceUtils.getURL("classpath:content/quotes.json")
        quoteList = ObjectMapper().readValue(url, QuoteList::class.java).quoteList
    }

    fun getQuoteFromSource(source: String): Quote {
        return quoteList.filter { it.source.contains(source, ignoreCase = true) }.random()
    }

    fun getRandomQuote(): Quote {
        return quoteList.random()
    }
}
