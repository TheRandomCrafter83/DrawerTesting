package com.coderz.f1.drawertesting

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun AppTopBar(title: String="", buttonIcon: ImageVector, onButtonClicked:()->Unit){
    TopAppBar (
        title ={
            Text(
                title,
                color = MaterialTheme.colors.onSurface
            )
        },
        navigationIcon = {
            IconButton(onClick = {onButtonClicked()}) {
                Icon(buttonIcon, contentDescription = "",
                tint = MaterialTheme.colors.onSurface)
            }
        },
        backgroundColor =
            if(isSystemInDarkTheme()){
                MaterialTheme.colors.primarySurface
            } else {
                MaterialTheme.colors.primary
            }

            )
}