package o.mysin.sportsnewsviewer.di

import o.mysin.sportsnewsviewer.data.NewsRepository
import o.mysin.sportsnewsviewer.data.NewsRepositoryImpl
import o.mysin.sportsnewsviewer.data.remote.ApiService
import o.mysin.sportsnewsviewer.data.remote.PostPagingDataSource
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {

    singleOf(::NewsRepositoryImpl) { bind<NewsRepository>() }
    singleOf(::ApiService)
    singleOf(::PostPagingDataSource)

}