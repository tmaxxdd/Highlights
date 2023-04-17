package pl.tkadziolka.highlights.internal.locator

import pl.tkadziolka.highlights.model.PhraseLocation
import pl.tkadziolka.highlights.internal.SyntaxTokens.MULTILINE_COMMENT_DELIMITERS
import pl.tkadziolka.highlights.internal.indicesOf

private const val START_INDEX = 0

internal object MultilineCommentLocator {

    fun locate(code: String): List<PhraseLocation> {
        val locations = mutableListOf<PhraseLocation>()
        val comments = mutableListOf<Pair<Int, Int>>()
        val startIndices = mutableListOf<Int>()
        val endIndices = mutableListOf<Int>()

        MULTILINE_COMMENT_DELIMITERS.forEach { commentBlock ->
            val (prefix, postfix) = commentBlock
            startIndices.addAll(code.indicesOf(prefix))
            endIndices.addAll(code.indicesOf(postfix).map { it + (postfix.lastIndex) })
        }

        val endIndex = minOf(startIndices.size, endIndices.size) -1
        for (i in START_INDEX..endIndex) {
            comments.add(Pair(startIndices[i], endIndices[i]))
        }

        comments.forEach {
            val (start, end) = it
            val ending = end + 1 // Phrase end + '/' comment terminator
            locations.add(PhraseLocation(start, ending))
        }

        return locations
    }
}