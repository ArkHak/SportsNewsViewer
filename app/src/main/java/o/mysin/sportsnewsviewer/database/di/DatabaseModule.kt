package o.mysin.sportsnewsviewer.database.di

import o.mysin.sportsnewsviewer.database.SportsNewsDao
import o.mysin.sportsnewsviewer.database.SportsNewsDatabase
import org.koin.dsl.module

val databaseModule = module {

    single<SportsNewsDao> {
        SportsNewsDatabase.getDatabase(get()).sportsNewsDao()
    }

}