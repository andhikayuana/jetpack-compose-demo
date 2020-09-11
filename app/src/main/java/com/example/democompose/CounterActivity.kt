package com.example.democompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview

class CounterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterScreen()
        }
    }
}

@Composable
fun CounterScreen() {
    val counterState = remember {
        mutableStateOf(0)
    }

    Button(
        onClick = {
            counterState.value += 1
        }
    ) {
        Text(text = "Sudah klik ke-${counterState.value}")
    }
}


@Preview(
    showBackground = true,
    name = "Preview Counter"
)
@Composable
fun PreviewCounterScreen() {
    CounterScreen()
}