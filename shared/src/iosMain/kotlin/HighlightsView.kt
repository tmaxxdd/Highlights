import androidx.compose.ui.window.ComposeUIViewController
import dev.snipme.highlights.Highlights
import pl.tkadziolka.highlights.view.CodeTextView

fun CodeTextViewUiViewController(
    highlights: Highlights,
) = ComposeUIViewController {
    CodeTextView(
        highlights = highlights
    )
}