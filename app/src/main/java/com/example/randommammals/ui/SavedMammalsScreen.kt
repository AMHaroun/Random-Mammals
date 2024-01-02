package com.example.randommammals.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.randommammals.R
import com.example.randommammals.viewmodels.SavedMammalsScreenViewModel

@Composable
fun SavedMammalsScreen(
    modifier: Modifier = Modifier,
    viewModel: SavedMammalsScreenViewModel = hiltViewModel()
){
    val uiState = viewModel.uiState

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_360),
            contentDescription = null,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        
        LazyVerticalGrid(columns = GridCells.Adaptive(128.dp)){
            items(uiState.savedMammals.size){
               SavedMammalCard(
                   saveImageToPhotos = {  },
                   imageUrl = uiState.savedMammals[it],
                   modifier = Modifier.padding(8.dp)
               )
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedMammalCard(
    modifier: Modifier = Modifier,
    saveImageToPhotos: ()->Unit,
    imageUrl: String,
){
    val openDialog = remember { mutableStateOf(false)  }
    Card(
        modifier = modifier.size(50.dp,150.dp),
        onClick = {openDialog.value = true},
        elevation = CardDefaults.cardElevation(defaultElevation = 16.dp)
    ){
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            placeholder = painterResource(id = R.drawable.placeholder_image)
        )
        if (openDialog.value) {

            AlertDialog(
                onDismissRequest = {
                    openDialog.value = false
                },
                title = {
                    Text(text = "Save image to photos?")
                },
                confirmButton = {
                    Button(
                        onClick = {
                            openDialog.value = false
                            saveImageToPhotos()
                        }) {
                        Text("Yes")
                    }
                },
                dismissButton = {
                    Button(
                        onClick = {
                            openDialog.value = false
                        }) {
                        Text("Dismiss")
                    }
                }
            )
        }
    }
}

@Preview
@Composable
fun SavedMammalCardPreview(){
    SavedMammalCard(
        imageUrl = "",
        saveImageToPhotos = {}
    )
}

