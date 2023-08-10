package com.example.moviereview.ui.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.moviereview.ui.presentation.home.homeScreen
import com.example.moviereview.ui.presentation.home.tabs.searchScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainNavHost() {
    val navController = rememberNavController()

    MaterialTheme {
        Scaffold(
            modifier = Modifier,
            bottomBar = { AppBottomBar(navController = navController) }
        ) { padding ->
            NavHost(
                modifier = Modifier.padding(padding),
                navController = navController,
                startDestination = NavigationBarScreen.HomeScreen.route,
            ) {
                homeScreen()
                searchScreen()
            }
        }
    }
}

@Composable
fun AppBottomBar(
    navController: NavHostController,
) {
    val navigationBarScreen = listOf(
        NavigationBarScreen.HomeScreen,
        NavigationBarScreen.SearchScreen,
        NavigationBarScreen.CategoryScreen,
        NavigationBarScreen.ProfileScreen,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        navigationBarScreen.forEach { screen ->
            val isTabSelected = currentDestination?.route == screen.route
            NavigationBarItem(
                label = { screen.label },
                icon = {
                    Icon(
                        painter = painterResource(screen.iconResource),
                        contentDescription = screen.route,
                    )
                },
                selected = isTabSelected,
                onClick = {
                    navController.navigateToBottomBarRoute(screen.route)
                },
            )
        }
    }
}

fun NavHostController.navigateToBottomBarRoute(route: String) {
    navigate(route) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
            inclusive = true
        }
        launchSingleTop = true
        restoreState = true
    }
}