package o.mysin.sportsnewsviewer.navigations.main

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import o.mysin.sportsnewsviewer.R
import o.mysin.sportsnewsviewer.features.favorite.ui.FavoriteScreen
import o.mysin.sportsnewsviewer.navigations.LocalNavHost
import o.mysin.sportsnewsviewer.features.feeds.ui.FeedsScreen
import o.mysin.sportsnewsviewer.navigations.AppScreens
import o.mysin.sportsnewsviewer.features.settings.ui.SettingsScreen
import o.mysin.sportsnewsviewer.ui.theme.SportsTheme

private sealed class MainScreens {
    @Serializable
    data object Feeds : MainScreens()

    @Serializable
    data object Favorite : MainScreens()

    @Serializable
    data object Settings : MainScreens()
}

private enum class BottomTabs(
    val title: String,
    val icon: Int,
    val route: MainScreens,
) {
    News("Новости", R.drawable.ic_feed, MainScreens.Feeds),
    Favorite("Избранное", R.drawable.ic_favorite, MainScreens.Favorite),
    Settings("Настройки", R.drawable.ic_settings, MainScreens.Settings)
}

private val startDestinationScreen = MainScreens.Feeds

@SuppressLint("RestrictedApi")
@Composable
fun MainScreen() {
    val outerNavController = LocalNavHost.current
    val navController = rememberNavController()
    val items = BottomTabs.entries.toTypedArray()
    Scaffold(
        modifier = Modifier.fillMaxSize()
            .background(color = SportsTheme.colors.primaryBackground),
        bottomBar = {
            BottomNavigation(
                modifier = Modifier,
                backgroundColor = SportsTheme.colors.bottomNavigation
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination =
                    navBackStackEntry?.destination?.route?.substringAfterLast(".")

                items.forEach { screen ->
                    val isSelected = currentDestination == screen.route.toString()
                    BottomNavigationItem(
                        selected = isSelected,
                        icon = {
                            Icon(
                                painter = painterResource(screen.icon),
                                contentDescription = screen.title,
                                tint = if (isSelected) SportsTheme.colors.accentColor else SportsTheme.colors.secondaryText,
                            )
                        },
                        label = {
                            Text(
                                text = screen.title,
                                fontSize = 12.sp,
                                color = if (isSelected) SportsTheme.colors.accentColor else SportsTheme.colors.secondaryText,
                            )
                        },
                        selectedContentColor = SportsTheme.colors.accentColor,
                        unselectedContentColor = SportsTheme.colors.secondaryText,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(startDestinationScreen) {
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
        NavHost(
            navController = navController,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            startDestination = startDestinationScreen
        ) {
            composable<MainScreens.Feeds> {
                FeedsScreen(
                    feedClick = { feedId ->
                        outerNavController.navigate(AppScreens.Detail(feedId = feedId)){
                            popUpTo(AppScreens.Main) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }

            composable<MainScreens.Favorite> {
                FavoriteScreen(
                    feedClick = { feedId ->
                        outerNavController.navigate(AppScreens.Detail(feedId = feedId))
                    }
                )
            }

            composable<MainScreens.Settings> { SettingsScreen() }
        }
    }
}
