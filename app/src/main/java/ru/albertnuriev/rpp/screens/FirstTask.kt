package ru.albertnuriev.rpp.screens

import android.icu.util.CurrencyAmount
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.albertnuriev.rpp.navigation.NavRoute
import ru.albertnuriev.rpp.ui.theme.RPPTheme
import ru.albertnuriev.rpp.R
import java.text.NumberFormat


@Composable
fun FirstTaskScreen (navController: NavController) {
    var amountInput by remember { mutableStateOf("") }
    val amount = amountInput.toIntOrNull() ?: 0
    val tip = calculate(amount)
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
            Spacer(Modifier.height(16.dp))
        //Пойдёт вызов textField
            EditNumberField(
                value = amountInput,
                onValueChanged = { amountInput = it }
            )
            //КНОПКА
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Вывод:",
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .align(Start),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(24.dp))
            Text(
                text = tip,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 10.dp),
                fontSize = 15.sp,
                textAlign = TextAlign.Justify
            )
            //Кнопка запуска


        }
    }
}

@Composable
fun EditNumberField(
    value: String,
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        label = { Text("Введите число от 0 до 999") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

private fun calculate (
    amount: Int
) : String {
    val counter = amount
    var spisok = mutableListOf<String>()
    val tip = amount
    for (i in 1..counter) {
        var number = i
        val numberSquare = i * i
        var numberlength = i.toString().length.toInt()
        val zeroNumbers = when (numberlength) {
            1 -> 10
            2 -> 100
            else -> 1000
        }
        if (number == numberSquare % zeroNumbers) {
            spisok.add("$number = $numberSquare")
        }
    }


    //return NumberFormat.getCurrencyInstance().format(tip)
    return spisok.toString()
}

@Preview(showBackground = true)
@Composable
fun Lookslike() {
    RPPTheme() {
        FirstTaskScreen(navController = rememberNavController())
    }
}