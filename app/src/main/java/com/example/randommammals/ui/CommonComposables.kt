package com.example.randommammals.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.randommammals.R

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    home: ()->Unit,
    saved: ()->Unit
) {
    NavigationBar(
        modifier = modifier.clip(RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp)),
        tonalElevation = 32.dp,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = null,
                modifier = Modifier.size(50.dp)
                    .clickable { home() }
            )
            Icon(
                painter = painterResource(id = R.drawable.baseline_archive_24),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
                    .clickable { saved() }
            )
        }
    }
}

@Preview(
    showSystemUi = true
)
@Composable
fun NavigationBarPreview(){
    BottomNavigationBar(home = {}, saved = {})
}