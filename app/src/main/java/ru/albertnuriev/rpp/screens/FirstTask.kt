package ru.albertnuriev.rpp.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.albertnuriev.rpp.navigation.NavRoute
import ru.albertnuriev.rpp.ui.theme.RPPTheme
import ru.albertnuriev.rpp.R


@Composable
fun FirstTaskScreen (navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Задание 1")
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(route = NavRoute.Start.route) }) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White,
                elevation = 10.dp
            )
        }) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Задание 1",
                modifier = Modifier
                    .padding()
                    .align(CenterHorizontally),
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.text1),
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .align(CenterHorizontally),
                fontSize = 14.sp,
                textAlign = TextAlign.Justify
            )


        }
    }
}

@Preview(showBackground = true)
@Composable
fun Lookslike() {
    RPPTheme() {
        FirstTaskScreen(navController = rememberNavController())
    }
}