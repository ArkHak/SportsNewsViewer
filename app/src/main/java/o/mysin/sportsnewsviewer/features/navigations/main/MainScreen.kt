package o.mysin.sportsnewsviewer.features.navigations.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import o.mysin.sportsnewsviewer.features.favorite.FavoriteScreen
import o.mysin.sportsnewsviewer.features.navigations.LocalNavHost
import o.mysin.sportsnewsviewer.features.news.NewsScreen
import o.mysin.sportsnewsviewer.features.settings.SettingsScreen

sealed class MainScreens {
    @Serializable
    data object News : MainScreens()

    @Serializable
    data object Favorite : MainScreens()

    @Serializable
    data object Settings : MainScreens()
}


enum class BottomTabs(
    val title: String,
    val icon: ImageVector,
    val route: MainScreens,
) {
    News("News", Icons.Default.Home, MainScreens.News),
    Favorite("Favorite", Icons.Default.Favorite, MainScreens.Favorite),
    SETTINGS("ScreenB", Icons.Default.Settings, MainScreens.Settings)
}

@SuppressLint("RestrictedApi")
@Composable
fun MainScreen() {
    val outerNavController = LocalNavHost.current
    val navController = rememberNavController()
    val items = BottomTabs.entries.toTypedArray()
    val bottomNavigationHeight = 75.dp
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigation(
                modifier = Modifier
//                    .height(bottomNavigationHeight)
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                items.forEach { screen ->
                    val isSelected =
                        currentDestination?.hierarchy?.any { it.route == screen.route.toString() } == true
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = screen.icon,
                                contentDescription = screen.title
                            )
                        },
                        label = {
                            Text(text = screen.title)
                        },
                        selected = isSelected,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().displayName) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
        ) {

        }
        NavHost(
            navController = navController,
            modifier = Modifier
                .padding(bottom = bottomNavigationHeight)
                .fillMaxHeight(),
            startDestination = MainScreens.News
        ) {
            composable<MainScreens.News> { NewsScreen() }
            composable<MainScreens.Favorite> { FavoriteScreen() }
            composable<MainScreens.Settings> { SettingsScreen() }
        }
    }
}