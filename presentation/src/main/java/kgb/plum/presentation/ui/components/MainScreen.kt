package kgb.plum.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kgb.plum.presentation.model.MainMenu
import kumoh.whale.whale.ui.theme.WhaleTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kumoh.whale.whale.ui.theme.colors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController : NavHostController) {
    val mainNavController = rememberNavController()
    Scaffold(
        bottomBar = {
            MainNavigationBar(navController = mainNavController)
        }
    ) {
        it
        MainNavigationScreen(mainNavController)
    }
}

@Composable
fun MainNavigationBar(navController: NavHostController) {
    val bottomNavigationItems = listOf(
        MainMenu.Home,
        MainMenu.Domain,
        MainMenu.Recommend,
        MainMenu.WishList,
        MainMenu.MyPage,
    )

    NavigationBar(

    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        bottomNavigationItems.forEach {item ->
            NavigationBarItem(
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = item.res),
                            contentDescription = item.name,
                            modifier = Modifier.size(36.dp),
                            tint = if(currentRoute == item.name) MaterialTheme.colors.surface else MaterialTheme.colors.primary
                        )
                        Text(
                            text = item.name,
                            color = if(currentRoute == item.name) MaterialTheme.colors.surface else MaterialTheme.colors.primary,
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors(indicatorColor = MaterialTheme.colors.primary),
                selected = currentRoute == item.name,
                onClick = {
                    navController.navigate(item.name) {
                        navController.graph?.startDestinationRoute?.let {
                            popUpTo(it) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun MainNavigationScreen(navController : NavHostController) {
    NavHost(navController = navController, startDestination = MainMenu.Home.name) {
        composable(route = MainMenu.Home.name){
            Text("This is Main")
        }
        composable(route = MainMenu.Domain.name){
            Text("This is Category")
        }
        composable(route = MainMenu.Recommend.name){
            Text("This is MyPage")
        }
        composable(route = MainMenu.WishList.name){
            Text("This is MyPage")
        }
        composable(route = MainMenu.MyPage.name){
            Text("This is MyPage")
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    WhaleTheme {
        MainScreen(navController = rememberNavController())
    }
}