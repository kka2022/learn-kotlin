package com.example.learningviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learningviewmodel.ui.theme.LearningViewmodelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningViewmodelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                    shadowElevation = 8.dp
                ) {
                    LearningViewmodel()
                }
            }
        }
    }
}

@Composable
fun LearningViewmodel() {

    val clickViewModel = viewModel<ClickViewModel>()
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = clickViewModel.clickTimes.toString(), fontSize = 40.sp)
        Spacer(modifier = Modifier.size(30.dp))
        Button(onClick = { clickViewModel.incrementClickTimes() }) {
            Text(text = "Clicked ${clickViewModel.clickTimes} times", fontSize = 30.sp)
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    LearningViewmodel()
}