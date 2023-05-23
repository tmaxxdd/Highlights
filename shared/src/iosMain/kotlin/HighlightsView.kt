import androidx.compose.ui.window.ComposeUIViewController
import pl.tkadziolka.highlights.Highlights
import pl.tkadziolka.highlights.view.CodeTextView

fun CodeTextViewUiViewController(
    highlights: Highlights,
) = ComposeUIViewController {
    CodeTextView(
        highlights = highlights
    )
}