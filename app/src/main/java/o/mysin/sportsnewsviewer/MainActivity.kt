package o.mysin.sportsnewsviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import o.mysin.sportsnewsviewer.ui.theme.SportsNewsViewerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SportsNewsViewerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->

                }
            }
        }
    }
}
