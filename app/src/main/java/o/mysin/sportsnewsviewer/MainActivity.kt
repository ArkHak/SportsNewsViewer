package o.mysin.sportsnewsviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import o.mysin.sportsnewsviewer.features.navigations.AppScreens
import o.mysin.sportsnewsviewer.features.navigations.LocalNavHost
import o.mysin.sportsnewsviewer.features.navigations.main.MainScreen
import o.mysin.sportsnewsviewer.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            AppTheme {
                val navController: NavHostController = rememberNavController()
                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentScreen = backStackEntry?.destination?.route ?: AppScreens.Main.title

                CompositionLocalProvider(
                    LocalNavHost provides navController
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = currentScreen
                    ) {
                        composable(route = AppScreens.Main.title) {
                            MainScreen()
                        }

                    }
                }
            }
        }
    }
}