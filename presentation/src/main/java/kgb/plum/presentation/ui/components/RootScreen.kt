package kgb.plum.presentation.ui.components

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kgb.plum.presentation.model.Screen
import kgb.plum.presentation.ui.components.signup.SignUpScreen
import kgb.plum.presentation.ui.theme.colors
import kgb.plum.presentation.viewmodel.LoginViewModel

@Composable
fun RootScreen(context: Context){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        modifier = Modifier.background(MaterialTheme.colors.background),
        startDestination = Screen.Login.name) {
        composable(Screen.Login.name) {
           LoginScreen(contextActivity = context, navController = navController)
        }
        composable(Screen.SignUp.name) {
            SignUpScreen(navController = navController)
        }
        composable(Screen.Main.name) {
            MainScreen(navController = navController)
        }
    }
}