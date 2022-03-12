package com.coderz.f1.drawertesting

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@Composable
fun AppMainScreen() {
    val navController = rememberNavController()
    Surface(color = MaterialTheme.colors.background) {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        val openDrawer = {
            scope.launch {
                drawerState.open()
            }
        }
        ModalDrawer(drawerState = drawerState,
            gesturesEnabled = drawerState.isOpen,
            drawerContent = {
                AppDrawer(onDestinationClicked = { route ->
                    scope.launch {
                        drawerState.close()
                    }
                    navController.navigate(route) {
                        popUpTo = navController.graph.startDestinationId
                        launchSingleTop = true
                    }
                }
                )
            }
        )
        {

            NavHost(navController = navController, startDestination = AppDrawerScreens.Home.route) {
                composable(AppDrawerScreens.Home.route) {
                    Home(
                        openDrawer = {
                            openDrawer()
                        }
                    )
                }
                composable(AppDrawerScreens.Settings.route) {
                    Settings(
                        openDrawer = {
                            openDrawer()
                        }
                    )
                }
                composable(AppDrawerScreens.About.route) {
                    About(
                        navController = navController
                    )
                }

            }


        }
    }
}