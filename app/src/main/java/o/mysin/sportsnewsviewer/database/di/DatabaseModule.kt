package o.mysin.sportsnewsviewer.database.di

import o.mysin.sportsnewsviewer.database.SportsNewsDao
import o.mysin.sportsnewsviewer.database.SportsNewsDatabase
import o.mysin.sportsnewsviewer.database.mapper.FavoriteNewsEntityMapper
import o.mysin.sportsnewsviewer.database.mapper.FavoriteNewsEntityMapperImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val databaseModule = module {

    single<SportsNewsDao> {
        SportsNewsDatabase.getDatabase(get()).sportsNewsDao()
    }

    singleOf(::FavoriteNewsEntityMapperImpl) {
        bind<FavoriteNewsEntityMapper>()
    }

}