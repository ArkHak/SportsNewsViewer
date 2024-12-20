package o.mysin.sportsnewsviewer

import android.app.Application
import o.mysin.sportsnewsviewer.data.di.dataModule
import o.mysin.sportsnewsviewer.data.di.mappersDataModule
import o.mysin.sportsnewsviewer.database.di.databaseModule
import o.mysin.sportsnewsviewer.features.detailsfeed.di.detailsFeedModule
import o.mysin.sportsnewsviewer.features.favorite.di.favoriteModule
import o.mysin.sportsnewsviewer.features.feeds.di.feedsModule
import o.mysin.sportsnewsviewer.features.settings.di.settingsModule
import o.mysin.sportsnewsviewer.network.di.networkModule
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
                feedsModule,
                detailsFeedModule,
                networkModule,
                databaseModule,
                settingsModule,
                favoriteModule,
                mappersDataModule,
                dataModule
            )
        }
    }
}