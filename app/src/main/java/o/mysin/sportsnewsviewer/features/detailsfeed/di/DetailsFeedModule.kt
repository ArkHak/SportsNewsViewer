package o.mysin.sportsnewsviewer.features.detailsfeed.di

import o.mysin.sportsnewsviewer.data.mappers.MapNewsDetailsDTOToNewsDetailsUI
import o.mysin.sportsnewsviewer.features.detailsfeed.presentation.DetailsFeedViewModel
import o.mysin.sportsnewsviewer.features.detailsfeed.presentation.usecase.GetNewsByIdUseCase
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val detailsFeedModule = module {
    viewModelOf(::DetailsFeedViewModel)
    singleOf(::GetNewsByIdUseCase)
    singleOf(::MapNewsDetailsDTOToNewsDetailsUI)
}
