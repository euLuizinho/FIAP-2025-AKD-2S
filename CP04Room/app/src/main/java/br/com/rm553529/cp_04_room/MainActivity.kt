package br.com.rm553529.cp_04_room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import br.com.rm553529.cp_04_room.features.city.data.local.db.AppDataBase
import br.com.rm553529.cp_04_room.features.city.data.local.repository.CityRepository
import br.com.rm553529.cp_04_room.features.city.presentation.screen.CityScreen
import br.com.rm553529.cp_04_room.features.city.presentation.screen.CityViewModel
import br.com.rm553529.cp_04_room.ui.theme.CP04RoomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val db = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java,
            "city_db"
        ).build()
        val repository = CityRepository(db.cityDao())
        val viewModel = CityViewModel(repository)
        setContent {
            CP04RoomTheme {
                CityScreen(viewModel)
            }
        }
    }
}

