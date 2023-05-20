import androidx.compose.ui.window.ComposeUIViewController
import pl.tkadziolka.highlights.Highlights
import pl.tkadziolka.highlights.model.PhraseLocation
import pl.tkadziolka.highlights.model.SyntaxLanguage
import pl.tkadziolka.highlights.model.SyntaxTheme
import pl.tkadziolka.highlights.model.SyntaxThemes
import pl.tkadziolka.highlights.view.CodeTextView
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import platform.UIKit.childViewControllers

fun CodeTextViewUiViewController(
    highlights: Highlights,
) = ComposeUIViewController {
    CodeTextView(
        highlights = highlights
    )
}