package o.mysin.sportsnewsviewer.database.di

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import o.mysin.sportsnewsviewer.database.FavoriteNewsDao
import o.mysin.sportsnewsviewer.database.SportNewsDatabase
import o.mysin.sportsnewsviewer.database.mapper.FavoriteNewsEntityMapper
import o.mysin.sportsnewsviewer.database.mapper.FavoriteNewsEntityMapperImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val databaseModule = module {

    single<FavoriteNewsDao> {
        SportNewsDatabase.getDatabase(get(), get(), get()).favoriteNewsDao()
    }

    single {
        CoroutineScope(Dispatchers.IO + Job())
    }

    singleOf(::FavoriteNewsEntityMapperImpl) {
        bind<FavoriteNewsEntityMapper>()
    }

}