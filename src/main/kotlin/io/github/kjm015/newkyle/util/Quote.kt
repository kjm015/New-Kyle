package io.github.kjm015.newkyle.util

data class Quote(val source: String = "Unknown", val quote: String = "") {
  fun displayString(): String {
    return """
      > $quote
      > - $source
    """.trimIndent()
  }
}

class QuoteList {
  var quoteList: List<Quote> = listOf()
}