package pl.tkadziolka.highlights.model

private const val DARCULA_KEY = "darcula"
private const val MONOKAI_KEY = "monokai"
private const val NOTEPAD_KEY = "notepad"
private const val MATRIX_KEY = "matrix"
private const val PASTEL_KEY = "pastel"


object SyntaxThemes {

    val themes = mapOf(
        DARCULA_KEY to SyntaxTheme(
            code = 0xEDEDED,
            keyword = 0xCC7832,
            string = 0x6A8759,
            literal = 0x6897BB,
            comment = 0x909090,
            metadata = 0xBBB529,
            multilineComment = 0x629755,
            punctuation = 0xCC7832,
            mark = 0xEDEDED
        ),
        MONOKAI_KEY to SyntaxTheme(
            code = 0xF8F8F2,
            keyword = 0xF92672,
            string = 0xE6DB74,
            literal = 0xAE81FF,
            comment = 0xFD971F,
            metadata = 0xB8F4B8,
            multilineComment = 0xFD971F,
            punctuation = 0xF8F8F2,
            mark = 0xF8F8F2
        ),
        NOTEPAD_KEY to SyntaxTheme(
            code = 0x000080,
            keyword = 0x0000FF,
            string = 0x808080,
            literal = 0xFF8000,
            comment = 0x008000,
            metadata = 0x000080,
            multilineComment = 0x008000,
            punctuation = 0xAA2C8C,
            mark = 0xAA2C8C
        ),
        MATRIX_KEY to SyntaxTheme(
            code = 0x008500, //
            keyword = 0x008500, //
            string = 0x269926, //
            literal = 0x39E639, //
            comment = 0x67E667, //
            metadata = 0x008500, //
            multilineComment = 0x67E667,
            punctuation = 0x008500,
            mark = 0x008500
        ),
        PASTEL_KEY to SyntaxTheme(
            code = 0xDFDEE0,
            keyword = 0x729FCF,
            string = 0x93CF55,
            literal = 0x8AE234,
            comment = 0x888A85,
            metadata = 0x5DB895,
            multilineComment = 0x888A85,
            punctuation = 0xCB956D,
            mark = 0xCB956D
        )
    )

    val default = themes[DARCULA_KEY]!!
    val darcula = themes[DARCULA_KEY]!!
    val monokai = themes[MONOKAI_KEY]!!
    val notepad = themes[NOTEPAD_KEY]!!
    val matrix = themes[MATRIX_KEY]!!
    val pastel = themes[PASTEL_KEY]!!

}