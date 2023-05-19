package kgb.plum.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kgb.plum.presentation.model.Screen
import kumoh.whale.whale.ui.theme.colors

@Composable
fun RootScreen(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Login.name) {
        composable(Screen.Login.name) {
           LoginScreen(navController = navController)
        }
        composable(Screen.SignUp.name) {
            SignUpScreen()
        }
        composable(Screen.Main.name) {
            MainScreen()
        }
    }
}