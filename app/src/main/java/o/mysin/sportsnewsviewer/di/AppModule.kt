package o.mysin.sportsnewsviewer.di

import o.mysin.sportsnewsviewer.data.NewsRepository
import o.mysin.sportsnewsviewer.data.NewsRepositoryImpl
import o.mysin.sportsnewsviewer.data.mappers.MapNewsDetailsDTOToNewsDetailsUI
import o.mysin.sportsnewsviewer.data.mappers.MapNewsItemDTOToNewsItemUI
import o.mysin.sportsnewsviewer.features.detailsfeed.presentation.DetailsFeedViewModel
import o.mysin.sportsnewsviewer.features.detailsfeed.presentation.usecase.GetNewsByIdUseCase
import o.mysin.sportsnewsviewer.features.feeds.presentation.FeedsViewModel
import o.mysin.sportsnewsviewer.features.feeds.presentation.usecase.GetNewsListUseCase
import o.mysin.sportsnewsviewer.network.NetworkApi
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {

    singleOf(::NewsRepositoryImpl) { bind<NewsRepository>() }

    //FeedsComponent
    viewModelOf(::FeedsViewModel)

    singleOf(::GetNewsListUseCase)

    singleOf(::MapNewsItemDTOToNewsItemUI)

    //DetailsComponent
    viewModelOf(::DetailsFeedViewModel)

    singleOf(::GetNewsByIdUseCase)

    singleOf(::MapNewsDetailsDTOToNewsDetailsUI)

    //Network
    single { NetworkApi.create() }
}