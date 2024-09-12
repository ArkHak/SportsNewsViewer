package o.mysin.sportsnewsviewer.database.di

import o.mysin.sportsnewsviewer.database.FavoriteNewsDao
import o.mysin.sportsnewsviewer.database.SportNewsDatabase
import o.mysin.sportsnewsviewer.database.mapper.FavoriteNewsEntityMapper
import o.mysin.sportsnewsviewer.database.mapper.FavoriteNewsEntityMapperImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val databaseModule = module {

    single<FavoriteNewsDao> {
        SportNewsDatabase.getDatabase(get()).favoriteNewsDao()
    }

    singleOf(::FavoriteNewsEntityMapperImpl) {
        bind<FavoriteNewsEntityMapper>()
    }

}