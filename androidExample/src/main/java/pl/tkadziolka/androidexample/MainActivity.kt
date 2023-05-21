package pl.tkadziolka.androidexample

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pl.tkadziolka.highlights.Highlights
import pl.tkadziolka.highlights.model.SyntaxLanguage
import pl.tkadziolka.highlights.model.SyntaxThemes
import pl.tkadziolka.highlights.view.CodeTextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setContent {
            App()
        }
    }
}

private val sampleCode =
    """
    class Main {
        public static void main(String[] args) {
            int abcd = 100;
        }
    }
    """.trimIndent()

@Composable
fun App() {
    var highlights = remember {
        Highlights
            .default()
            .getBuilder()
            .code(sampleCode)
            .build()
    }

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            CodeTextView(highlights = highlights)

            Dropdown(
                options = SyntaxLanguage.getNames(),
                selected = SyntaxLanguage.getNames().indexOfFirst {
                    it.equals(highlights.getLanguage().name, ignoreCase = true)
                }) { selectedLanguage ->
                highlights = highlights.getBuilder()
                    .language(SyntaxLanguage.getByName(selectedLanguage)!!)
                    .build()
            }

            Spacer(modifier = Modifier.size(16.dp))

            Dropdown(
                options = SyntaxThemes.light.keys.toList(),
                selected = SyntaxThemes.light.entries.indexOfFirst {
                    it.value == highlights.getTheme()
                }) { selectedTheme ->
                highlights = highlights.getBuilder()
                    .theme(SyntaxThemes.light[selectedTheme]!!)
                    .build()
            }
        }
    }
}