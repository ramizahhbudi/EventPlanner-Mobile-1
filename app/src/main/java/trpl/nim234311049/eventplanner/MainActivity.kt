package trpl.nim234311049.eventplanner

import Event
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val events = listOf(
                Event("Sarapan", 30, 800),
                Event("Makan Siang", 60, 1300),
                Event("Makan Malam", 45, 1900),
                Event("Meeting", 120, 1000)
            )

            // Tampilan daftar acara
            EventList(events)
        }
    }
}

@Composable
fun EventList(events: List<Event>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Daftar Acara",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 8.dp)
        )

        events.forEach { event ->
            EventCard(event)
        }
    }
}

@Composable
fun EventCard(event: Event) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFE8F5E9)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = event.nama,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1B5E20)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Durasi: ${event.durasi} menit",
                fontSize = 16.sp,
                color = Color(0xFF388E3C)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Waktu: ${event.waktuMulai} (24-jam format)",
                fontSize = 16.sp,
                color = Color(0xFF388E3C)
            )
        }
    }
}
