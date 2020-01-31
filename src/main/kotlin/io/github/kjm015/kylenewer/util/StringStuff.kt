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