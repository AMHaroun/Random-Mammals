package com.example.randommammals.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.randommammals.R
import com.example.randommammals.viewmodels.RandomMammalScreenUiState
import com.example.randommammals.viewmodels.RandomMammalScreenViewModel

@Composable
fun RandomMammalScreen(
    modifier: Modifier = Modifier,
    viewModel: RandomMammalScreenViewModel = hiltViewModel(),
){
    val uiState = viewModel.uiState
    
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Image(
            painter = painterResource(id = R.drawable.baseline_360),
            contentDescription = null,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        when(uiState) {
            is RandomMammalScreenUiState.Success-> {
                MammalImage(imageUrl = uiState.imageUrl)
            }
            is RandomMammalScreenUiState.Loading->{
                CircularProgressIndicator()
            }
            is RandomMammalScreenUiState.Error->{
                Image(
                    painter = painterResource(id = R.drawable.broken_image),
                    contentDescription = null
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
            ) {
            NextMammalButton {
                viewModel.getRandomMammal()
            }
            SaveMammalButton {
                viewModel.saveMammal()
            }
        }

    }

}

@Composable
fun MammalImage(
    modifier: Modifier = Modifier,
    imageUrl: String
){
    AsyncImage(
        model = imageUrl,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        placeholder = painterResource(id = R.drawable.placeholder_image),
        modifier = modifier
            .size(300.dp)
            .clip(RoundedCornerShape(32.dp))
    )
}

@Preview
@Composable
fun MammalImagePreview(){
    MammalImage(imageUrl = "")
}

@Composable
fun SaveMammalButton(
    modifier: Modifier = Modifier,
    saveMammal: ()->Unit
){
    Button(onClick = { saveMammal() }, modifier = modifier) {
       Text(text = "Save Mammal")
    }
}

@Preview(name = "SaveMammalButton")
@Composable
fun SaveMammalButtonPreview(){
    SaveMammalButton {}
}


@Composable
fun NextMammalButton(
    modifier: Modifier = Modifier,
    getNextMammal: () -> Unit
){
    Button(onClick = { getNextMammal() }, modifier = modifier) {
        Text(text = "Next Mammal")
    }
}

@Preview(name = "SaveMammalButton")
@Composable
fun NextMammalButtonPreview(){
    NextMammalButton {}
}