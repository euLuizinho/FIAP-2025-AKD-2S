package br.com.luizinho.watertracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.luizinho.watertracker.ui.theme.BackgroundColor
import br.com.luizinho.watertracker.ui.theme.PrimaryColor
import br.com.luizinho.watertracker.ui.theme.PrimaryDisabledColor
import br.com.luizinho.watertracker.ui.theme.SecondaryTextColor
import br.com.luizinho.watertracker.ui.theme.WaterTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WaterTrackerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //val viewModel : WaterViewModel = viewModel()
                    val repository: WaterRepository = InMemoryWaterRepository()
                    val factory = WaterViewModelFactory(repository)
                    val viewModel: WaterViewModel = viewModel(factory = factory)
                    WaterScreen(
                        waterUiState = viewModel.uiState,
                        onDrink = viewModel::drinkOneCup,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun WaterScreen(
    waterUiState: WaterUiState,
    onDrink: () -> Unit,
    modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(horizontal = 24.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            "Beba Água",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = PrimaryColor
        )
        Text(
            "HIDRATAÇÃO DIÁRIA",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = SecondaryTextColor

        )
        Spacer(modifier = Modifier.weight(1f))
        WaterIndicator(waterUiState.cupsDrunk, waterUiState.goalCups)
        Spacer(modifier = Modifier.weight(1f))
        ActionButtons(
            waterUiState.isGoalReached,
            onDrink
        )
    }
}

@Composable
fun WaterIndicator(cupsDrunk: Int, goalsCup: Int) {
    Column (horizontalAlignment =  Alignment.CenterHorizontally){
        Row {
            Text(
                text = "$cupsDrunk",
                fontSize = 48.sp,
                fontWeight = FontWeight.ExtraBold,
                color = PrimaryColor,
                modifier = Modifier.alignByBaseline()
            )


            Text(
                "/$goalsCup",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = SecondaryTextColor,
                modifier = Modifier.alignByBaseline()
            )
        }

        Text(
            text = if (cupsDrunk == 1) "COPO" else "COPOS",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = SecondaryTextColor
        )
    }
}

@Composable
fun ActionButtons(
    isGoalReached: Boolean,
    onDrink: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = onDrink,
            enabled = !isGoalReached,
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryColor,
                disabledContainerColor = PrimaryDisabledColor,
                contentColor = Color.White,
                disabledContentColor = Color.White
            ),
            elevation = ButtonDefaults.buttonElevation(6.dp)
        ) {
            Text(
                text = "BEBER 1 COPO (200 ML)",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}