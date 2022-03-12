package com.coderz.f1.drawertesting

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coderz.f1.drawertesting.ui.theme.DrawerTestingTheme

sealed class AppDrawerScreens(val title:String, val route:String){
    object Home: AppDrawerScreens("Home","home")
    object Settings:AppDrawerScreens("Settings","settings")
    object About:AppDrawerScreens("About","about")
}



private val screens = listOf(
    AppDrawerScreens.Home,
    AppDrawerScreens.Settings,
    AppDrawerScreens.About
)

@Composable
fun AppDrawer(
    modifier: Modifier = Modifier,
    onDestinationClicked:(rout:String)->Unit
){
    Column(
        modifier
            .fillMaxSize()
            .padding(start = 24.dp, top = 48.dp),
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = ""
        )
        screens.forEach{ screen ->
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text=screen.title,
                style = MaterialTheme.typography.h4,
                modifier=Modifier.clickable {
                    onDestinationClicked(screen.route)
                }
            )
        }
    }
}

