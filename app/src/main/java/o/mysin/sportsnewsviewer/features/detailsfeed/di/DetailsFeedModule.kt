package o.mysin.sportsnewsviewer.features.detailsfeed.di

import o.mysin.sportsnewsviewer.features.detailsfeed.presentation.DetailsFeedViewModel
import o.mysin.sportsnewsviewer.features.detailsfeed.domain.usecase.CheckExistsNewsDatabaseUseCase
import o.mysin.sportsnewsviewer.features.detailsfeed.domain.usecase.GetNewsByIdUseCase
import o.mysin.sportsnewsviewer.features.detailsfeed.domain.usecase.ChangeExistsNewsDatabaseUseCase
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val detailsFeedModule = module {
    viewModelOf(::DetailsFeedViewModel)
    singleOf(::GetNewsByIdUseCase)
    singleOf(::ChangeExistsNewsDatabaseUseCase)
    singleOf(::CheckExistsNewsDatabaseUseCase)
}
