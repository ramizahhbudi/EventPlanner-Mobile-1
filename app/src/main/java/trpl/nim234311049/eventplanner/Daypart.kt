package trpl.nim234311049.eventplanner

enum class Daypart {
    PAGI,
    SIANG,
    MALAM
}

fun getDaypart(waktu: Int): Daypart {
    return when (waktu) {
        in 0..1159 -> Daypart.PAGI
        in 1200..1759 -> Daypart.SIANG
        else -> Daypart.MALAM
    }
}
