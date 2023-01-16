package ru.albertnuriev.rpp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.albertnuriev.rpp.navigation.NavRoute
import ru.albertnuriev.rpp.navigation.NavRoute.FifthTask.route
import ru.albertnuriev.rpp.ui.theme.RPPTheme
import ru.albertnuriev.rpp.R

@Composable
fun StartScreen (navController: NavController) {
    Scaffold (
        topBar = {
            TopAppBar (
                title = {
                    Text(text = "RPP v4")
                })
        }
    )  {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(R.drawable.harold2) ,
                contentDescription = "Pain"
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Нуриев Альберт,",
                fontFamily = FontFamily.Serif,
                fontSize = 30.sp
            )
            Text(
                text = "студент группы 9216",
                fontFamily = FontFamily.Serif,
                fontSize = 25.sp
            )
            Button(
                onClick = {
                    navController.navigate(route = NavRoute.FirstTask.route)
                },
                modifier = Modifier
                    .width(230.dp)
                    .padding(vertical = 4.dp)
            ) {
                Text(text = "Задание 1")
            }
            OutlinedButton(
                onClick = {
                    navController.navigate(route = NavRoute.SecondTask.route)
                },
                modifier = Modifier
                    .width(230.dp)
                    .padding(vertical = 4.dp)
            ) {
                Text(text = "Задание 2")
            }
            Button(
                onClick = {
                    navController.navigate(route = NavRoute.ThirdTask.route)
                },
                modifier = Modifier
                    .width(230.dp)
                    .padding(vertical = 4.dp)
            ) {
                Text(text = "Задание 3")
            }
            OutlinedButton(
                onClick = {
                    navController.navigate(route = NavRoute.FourthTask.route)
                },
                modifier = Modifier
                    .width(230.dp)
                    .padding(vertical = 4.dp)
            ) {
                Text(text = "Задание 4")
            }
            Button(
                onClick = {
                    navController.navigate(route = NavRoute.FifthTask.route)
                },
                modifier = Modifier
                    .width(230.dp)
                    .padding(vertical = 4.dp)
            ) {
                Text(text = "Задание 5")
            }
          OutlinedButton(
                onClick = {
                    navController.navigate(route = NavRoute.Inf.route)
                },
                modifier = Modifier
                    .width(230.dp)
                    .padding(vertical = 4.dp)
            ) {
                Text(text = "Обо мне")
            }

        /*//val a = navController.navigate(route = NavRoute.ThirdTask.route)
            buttons(path = navController.navigate(route = NavRoute.ThirdTask.route), inf = "Кнопка 3")
                //buttons(navController = navController.navigate(route = NavRoute.FourthTask.route), "Кнопка 4")*/
        }
    }
}



/*
@Composable
fun buttons (path: Unit, inf: String) {
    Button(
        onClick = {
                path
        },
        modifier = Modifier
            .width(400.dp)
            .padding(vertical = 8.dp)
    ) {
        // Сюда на вход вторую переменную
        Text(text = inf)
    }
}
 */



@Preview(showBackground = true)
@Composable
fun prevStartScreen () {
    RPPTheme {
        StartScreen(navController = rememberNavController())
    }
}