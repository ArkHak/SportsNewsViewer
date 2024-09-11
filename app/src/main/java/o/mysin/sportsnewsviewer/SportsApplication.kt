package o.mysin.sportsnewsviewer

import android.app.Application
import o.mysin.sportsnewsviewer.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SportsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@SportsApplication)
            modules(
                appModule
            )
        }
    }
}