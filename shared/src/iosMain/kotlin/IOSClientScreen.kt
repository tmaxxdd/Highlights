import androidx.compose.ui.window.ComposeUIViewController
import pl.tkadziolka.highlights.model.PhraseLocation
import pl.tkadziolka.highlights.model.SyntaxLanguage
import pl.tkadziolka.highlights.model.SyntaxTheme
import pl.tkadziolka.highlights.view.CodeTextView

fun CodeTextViewUiViewController(
    code: String,
    language: SyntaxLanguage,
    theme: SyntaxTheme,
    emphasisLocations: List<PhraseLocation> = emptyList()
) = ComposeUIViewController {
    CodeTextView(
        code = code,
        language = language,
        theme = theme,
        emphasisLocations = emphasisLocations
    )
}