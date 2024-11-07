data class Event(
    val nama: String,
    val durasi: Int, // Durasi dalam menit
    val waktuMulai: Int // Waktu mulai dalam format 24 jam, misalnya 1300 untuk 1:00 PM
)

enum class Daypart {
    PAGI, SIANG, MALAM
}

fun getDaypart(waktu: Int): Daypart {
    return when (waktu) {
        in 0..1159 -> Daypart.PAGI
        in 1200..1759 -> Daypart.SIANG
        else -> Daypart.MALAM
    }
}

fun filterEventsByDaypart(events: List<Event>, daypart: Daypart): List<Event> {
    return events.filter { getDaypart(it.waktuMulai) == daypart }
}

fun filterEventsByDuration(events: List<Event>, minimalDurasi: Int): List<Event> {
    return events.filter { it.durasi >= minimalDurasi }
}
