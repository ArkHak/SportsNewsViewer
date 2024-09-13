package o.mysin.sportsnewsviewer.features.feeds.di

import o.mysin.sportsnewsviewer.features.feeds.presentation.FeedsViewModel
import o.mysin.sportsnewsviewer.features.feeds.presentation.usecase.GetNewsListUseCase
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val feedsModule = module {

    viewModelOf(::FeedsViewModel)
    singleOf(::GetNewsListUseCase)

}