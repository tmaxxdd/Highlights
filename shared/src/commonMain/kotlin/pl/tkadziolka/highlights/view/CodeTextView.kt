package pl.tkadziolka.highlights.view

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import pl.tkadziolka.highlights.Highlights
import pl.tkadziolka.highlights.model.BoldHighlight
import pl.tkadziolka.highlights.model.ColorHighlight
import pl.tkadziolka.highlights.model.PhraseLocation
import pl.tkadziolka.highlights.model.SyntaxLanguage
import pl.tkadziolka.highlights.model.SyntaxTheme

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