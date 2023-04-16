package pl.tkadziolka.highlights

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform