package o.mysin.sportsnewsviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import o.mysin.sportsnewsviewer.features.detailsfeed.ui.DetailsFeedScreen
import o.mysin.sportsnewsviewer.features.navigations.AppScreens
import o.mysin.sportsnewsviewer.features.navigations.LocalNavHost
import o.mysin.sportsnewsviewer.features.navigations.main.MainScreen
import o.mysin.sportsnewsviewer.ui.theme.AppTheme

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                val navController: NavHostController = rememberNavController()

                CompositionLocalProvider(
                    LocalNavHost provides navController
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .statusBarsPadding()
                            .navigationBarsPadding(),
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = AppScreens.Main,
                        ) {
                            composable<AppScreens.Main> {
                                MainScreen()
                            }
                            composable<AppScreens.Detail> {
                                DetailsFeedScreen() {
                                    navController.popBackStack()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}