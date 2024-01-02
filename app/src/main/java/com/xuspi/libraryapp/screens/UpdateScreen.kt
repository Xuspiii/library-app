package com.xuspi.libraryapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.xuspi.libraryapp.room.BookEntity
import com.xuspi.libraryapp.viewmodel.BookViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateScreen(viewModel: BookViewModel, bookId: String?, navHostController: NavHostController) {

    var inputBook by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Update the existing book", fontSize = 24.sp)

        OutlinedTextField(
            modifier = Modifier.padding(16.dp),
            value = inputBook,
            onValueChange = { inputBook = it },
            label = { Text(text = "Update book name") },
            placeholder = { Text(text = "New book name") }
        )
        
        Button(onClick = {
            var newBook = BookEntity(bookId!!.toInt(), inputBook)
            viewModel.updateBook(newBook)
            navHostController.navigate("MainScreen")

        }) {
            Text(text = "Update book")
        }
    }
}