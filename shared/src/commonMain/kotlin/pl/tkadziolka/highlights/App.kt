package pl.tkadziolka.highlights

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import pl.tkadziolka.highlights.model.BoldHighlight
import pl.tkadziolka.highlights.model.ColorHighlight
import pl.tkadziolka.highlights.model.PhraseLocation
import pl.tkadziolka.highlights.model.SyntaxLanguage
import pl.tkadziolka.highlights.model.SyntaxTheme
import pl.tkadziolka.highlights.model.SyntaxThemes

private val sampleCode =
    """
        var greetingText by remember { mutableStateOf("Hello, World!") }
        var showImage by remember { mutableStateOf(false) }
    """.trimIndent()

@Composable
fun App() {
    MaterialTheme {
        var greetingText by remember { mutableStateOf("Hello, World!") }
        var showImage by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                greetingText = "Hello, ${"World"}"
                showImage = !showImage
            }) {
                Text(greetingText)
            }
            AnimatedVisibility(showImage) {
                CodeTextView(
                    modifier = Modifier.background(Color.Black),
                    code = sampleCode,
                    language = SyntaxLanguage.KOTLIN,
                    theme = SyntaxThemes.pastel,
                )
            }
        }
    }
}

@Composable
fun CodeTextView(
    modifier: Modifier = Modifier,
    code: String,
    language: SyntaxLanguage,
    theme: SyntaxTheme,
    emphasisLocations: List<PhraseLocation> = emptyList()
) {
    val highlights = remember {
        Highlights.Builder(
            code,
            language,
            theme,
            emphasisLocations
        ).build().getHighlights()
    }

    Text(
        modifier = modifier,
        text = buildAnnotatedString {
            append(code)

            highlights
                .filterIsInstance<ColorHighlight>()
                .forEach {
                    addStyle(
                        SpanStyle(color = Color(it.rgb).copy(alpha = 1f)),
                        start = it.location.start,
                        end = it.location.end,
                    )
                }

            highlights
                .filterIsInstance<BoldHighlight>()
                .forEach {
                    addStyle(
                        SpanStyle(fontWeight = FontWeight.Bold),
                        start = it.location.start,
                        end = it.location.end,
                    )
                }
        })
}
