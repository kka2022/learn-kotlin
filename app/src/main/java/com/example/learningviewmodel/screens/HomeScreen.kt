package com.example.learningviewmodel.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.learningviewmodel.NameViewModel
import com.example.learningviewmodel.Person

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController, nameViewModel: NameViewModel) {

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
            label = { Text(text = "New Name") }
        )
        Spacer(modifier = Modifier.size(30.dp))
        Button(
            onClick = {
                nameViewModel.updateList(Person(name = newName, hobby = "Click to update"))
                nameViewModel.updateNewName("")
            }
        ) {
            Text(text = "Add name to list", fontSize = 24.sp)
        }
        Spacer(modifier = Modifier.size(30.dp))
        NamesListComponent(nameViewModel, navController)
    }
}

@Composable
fun NamesListComponent(
    nameViewModel: NameViewModel,
    navController: NavHostController
) {
    LazyColumn() {
        items(nameViewModel.personList) { person ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(4.dp)
                    .clickable {
                        navController.navigate(route = "detail/${person.id}")
                    }
            ) {
                Text(
                    text = person.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = "Hobby: ${person.hobby}",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}