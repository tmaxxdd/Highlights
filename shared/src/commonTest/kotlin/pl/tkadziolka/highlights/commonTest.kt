package pl.tkadziolka.highlights

import kotlin.test.Test
import kotlin.test.assertTrue

class CommonGreetingTest {

    @Test
    fun testExample() {
        assertTrue(Highlights.Builder().build().getHighlights().isEmpty())
    }
}