package com.coderz.f1.drawertesting

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun Home(openDrawer:()->Unit){
    Column(modifier=Modifier.fillMaxSize()) {
        AppTopBar("Home",
        buttonIcon = Icons.Filled.Menu,
            onButtonClicked = {openDrawer()}
            ) 
        Column(
            modifier=Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Home Page")
        }
    }
}

@Composable
fun Settings(openDrawer:()->Unit){
    Column(modifier=Modifier.fillMaxSize()) {
        AppTopBar("Settings",
            buttonIcon = Icons.Filled.Menu,
            onButtonClicked = {openDrawer()}
        )
        Column(
            modifier=Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Settings Page")
        }
    }
}

@Composable
fun About(navController: NavController){
    Column(modifier=Modifier.fillMaxSize()) {
        AppTopBar("About",
            buttonIcon = Icons.Filled.ArrowBack,
            onButtonClicked = {navController.popBackStack()}
        )
        Column(
            modifier=Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("About Page")
        }
    }
}