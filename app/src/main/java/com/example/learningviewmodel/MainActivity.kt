package com.example.learningviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
                    NamesList()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NamesList() {
    val nameViewModel = viewModel<NameViewModel>()
    val newName = nameViewModel.newName

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = newName, onValueChange = {
                nameViewModel.updateNewName(it)
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "New Name")}
        )
        Spacer(modifier = Modifier.size(30.dp))
        Button(onClick = { nameViewModel.updateList(newName) }) {
            Text(text = "Add name to list", fontSize = 24.sp)
        }
        Spacer(modifier = Modifier.size(30.dp))
        LazyColumn() {
            items(nameViewModel.namesList) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(4.dp)
                ) {
                    Text(
                        text = it,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    NamesList()
}