package pl.tkadziolka.androidexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import pl.tkadziolka.highlights.Highlights
import pl.tkadziolka.highlights.model.SyntaxLanguage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.text_view).text = Highlights
            .Builder(
                code = "// This is java",
                language = SyntaxLanguage.KOTLIN
            ).build().getHighlights().toString()
    }
}