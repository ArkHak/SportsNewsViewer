package o.mysin.sportsnewsviewer.data.di

import o.mysin.sportsnewsviewer.data.DataStoreManager
import o.mysin.sportsnewsviewer.data.NewsRepository
import o.mysin.sportsnewsviewer.data.NewsRepositoryImpl
import o.mysin.sportsnewsviewer.data.remote.ApiService
import o.mysin.sportsnewsviewer.data.remote.PostPagingDataSource
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {
    singleOf(::DataStoreManager)
    singleOf(::NewsRepositoryImpl) {
        bind<NewsRepository>()
    }
    singleOf(::ApiService)
    singleOf(::PostPagingDataSource)
}
