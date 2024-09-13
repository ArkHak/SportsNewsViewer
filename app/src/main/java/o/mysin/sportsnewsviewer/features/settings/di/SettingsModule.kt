package o.mysin.sportsnewsviewer.features.settings.di

import o.mysin.sportsnewsviewer.features.settings.presentation.SettingsViewModel
import o.mysin.sportsnewsviewer.features.settings.presentation.usecase.ClearFavoriteNewsDatabaseUseCase
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val settingsModule = module {
    viewModelOf(::SettingsViewModel)
    singleOf(::ClearFavoriteNewsDatabaseUseCase)
}