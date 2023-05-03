import androidx.compose.ui.window.ComposeUIViewController
import pl.tkadziolka.highlights.model.PhraseLocation
import pl.tkadziolka.highlights.model.SyntaxLanguage
import pl.tkadziolka.highlights.model.SyntaxTheme
import pl.tkadziolka.highlights.model.SyntaxThemes
import pl.tkadziolka.highlights.view.CodeTextView

fun CodeTextViewUiViewController(
    code: String,
    language: SyntaxLanguage = SyntaxLanguage.DEFAULT,
    theme: SyntaxTheme = SyntaxThemes.monokai,
    emphasisLocations: List<PhraseLocation> = emptyList()
) = ComposeUIViewController {
    CodeTextView(
        code = code,
        language = language,
        theme = theme,
        emphasisLocations = emphasisLocations
    )
}

fun CodeTextViewUiViewControllerDefault(code: String) =
    ComposeUIViewController {
        CodeTextView(
            code = code,
            language = SyntaxLanguage.DEFAULT,
            theme = SyntaxThemes.default,
            emphasisLocations = emptyList()
        )
    }