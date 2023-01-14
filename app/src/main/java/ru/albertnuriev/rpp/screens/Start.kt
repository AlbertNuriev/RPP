package ru.albertnuriev.rpp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.albertnuriev.rpp.navigation.NavRoute
import ru.albertnuriev.rpp.ui.theme.RPPTheme

@Composable
fun StartScreen (navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Нуриев А.М.",
                fontFamily = FontFamily.Serif,
                fontSize = 25.sp
            )
            Text(
                text = "студент группы 9216",
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp
            )
            Button(
                onClick = {
                    navController.navigate(route = NavRoute.FirstTask.route)
                },
                modifier = Modifier
                    .width(400.dp)
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Room Database")
            }
            Button(
                onClick = {
                    navController.navigate(route = NavRoute.SecondTask.route)
                },
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Fire Database")
            }
            buttons(NavRoute.FourthTask.route)
        }
    }
}


@Composable
fun buttons (navController: NavController, inf : String) {
    Button(
        onClick = {
                navController.navigate(route = NavRoute.ThirdTask.route)
        },
        modifier = Modifier
            .width(400.dp)
            .padding(vertical = 8.dp)
    ) {
        // Сюда на вход вторую переменную
        Text(text = inf)
    }
}



@Preview(showBackground = true)
@Composable
fun prevStartScreen () {
    RPPTheme {
        StartScreen(navController = rememberNavController())
    }
}