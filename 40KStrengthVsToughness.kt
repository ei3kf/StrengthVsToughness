package com.example.strengthvstoughness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StrengthVsToughnessScreen()
        }
    }
}

@Composable
fun StrengthVsToughnessScreen() {

    var strength by remember { mutableStateOf(4) }
    var toughness by remember { mutableStateOf(4) }

    val result = calculateWoundRoll(strength, toughness)

    MaterialTheme {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "40K Wound Roll",
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(32.dp)
            ) {

                StatPicker(
                    label = "Strength",
                    value = strength,
                    onMinus = {
                        if (strength > 1) strength--
                    },
                    onPlus = {
                        if (strength < 40) strength++
                    }
                )

                StatPicker(
                    label = "Toughness",
                    value = toughness,
                    onMinus = {
                        if (toughness > 1) toughness--
                    },
                    onPlus = {
                        if (toughness < 40) toughness++
                    }
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = result,
                fontSize = 72.sp
            )
        }
    }
}

@Composable
fun StatPicker(
    label: String,
    value: Int,
    onMinus: () -> Unit,
    onPlus: () -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = label, fontSize = 20.sp)

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Button(onClick = onMinus) {
                Text("-")
            }

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = value.toString(),
                fontSize = 32.sp
            )

            Spacer(modifier = Modifier.width(12.dp))

            Button(onClick = onPlus) {
                Text("+")
            }
        }
    }
}

fun calculateWoundRoll(strength: Int, toughness: Int): String {
    return when {
        strength >= toughness * 2 -> "2+"
        strength > toughness -> "3+"
        strength == toughness -> "4+"
        strength * 2 > toughness -> "5+"
        else -> "6+"
    }
}
