package o.mysin.sportsnewsviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
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
import androidx.navigation.toRoute
import o.mysin.sportsnewsviewer.features.detailsfeed.ui.DetailsFeedScreen
import o.mysin.sportsnewsviewer.navigations.AppScreens
import o.mysin.sportsnewsviewer.navigations.LocalNavHost
import o.mysin.sportsnewsviewer.navigations.main.MainScreen
import o.mysin.sportsnewsviewer.ui.theme.AppTheme
import o.mysin.sportsnewsviewer.ui.theme.SportsTheme

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
                            .background(color = SportsTheme.colors.primaryBackground)
                            .statusBarsPadding()
                            .navigationBarsPadding(),
                    ) {
                        NavHost(
                            modifier = Modifier
                                .background(color = SportsTheme.colors.primaryBackground),
                            navController = navController,
                            startDestination = AppScreens.Main,
                        ) {
                            composable<AppScreens.Main> {
                                MainScreen()
                            }
                            composable<AppScreens.Detail> {
                                val args = it.toRoute<AppScreens.Detail>()
                                DetailsFeedScreen(args.feedId) {
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