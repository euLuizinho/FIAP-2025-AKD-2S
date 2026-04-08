package br.com.luizinho.taskapp

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
import br.com.luizinho.taskapp.features.task.data.local.db.AppDatabase
import br.com.luizinho.taskapp.features.task.data.local.repository.TaskRepository
import br.com.luizinho.taskapp.features.task.presentation.screen.TaskScreen
import br.com.luizinho.taskapp.features.task.presentation.screen.TaskViewModel
import br.com.luizinho.taskapp.ui.theme.TaskAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "task_db"
        ).build()
        val repository = TaskRepository(db.taskDao())
        val viewModel = TaskViewModel(repository)
        setContent {
            TaskAppTheme {
                TaskScreen(viewModel)
            }
        }
    }
}