package pl.tkadziolka.highlights.internal.locator

import pl.tkadziolka.highlights.model.PhraseLocation
import pl.tkadziolka.highlights.internal.SyntaxTokens.STRING_DELIMITERS
import pl.tkadziolka.highlights.internal.indicesOf

private const val START_INDEX = 0
private const val TWO_ELEMENTS = 2
private const val QUOTE_ENDING_POSITION = 1

internal object StringLocator {

    fun locate(code: String): List<PhraseLocation> = findStrings(code)

    private fun findStrings(code: String): List<PhraseLocation> {
        val locations = mutableListOf<PhraseLocation>()
        val textIndices = mutableListOf<Int>()

        // Find index of each string delimiter like " or ' or """
        STRING_DELIMITERS.forEach {
            textIndices += code.indicesOf(it)
        }

        // For given indices find words between
        for (i in START_INDEX..textIndices.lastIndex step TWO_ELEMENTS) {
            locations.add(PhraseLocation(textIndices[i], textIndices[i + 1] + QUOTE_ENDING_POSITION))
        }

        return locations
    }
}