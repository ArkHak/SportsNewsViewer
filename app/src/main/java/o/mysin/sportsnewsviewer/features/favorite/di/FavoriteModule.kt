package o.mysin.sportsnewsviewer.features.favorite.di

import o.mysin.sportsnewsviewer.features.favorite.presentation.FavoriteViewModel
import o.mysin.sportsnewsviewer.features.favorite.domain.usecase.GetFavoriteNewsListUseCase
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val favoriteModule = module {
    viewModelOf(::FavoriteViewModel)
    singleOf(::GetFavoriteNewsListUseCase)
}