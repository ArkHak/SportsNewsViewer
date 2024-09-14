package o.mysin.sportsnewsviewer.data.di

import o.mysin.sportsnewsviewer.data.mappers.dtoToUI.MapNewsDetailsDTOToNewsDetailsUI
import o.mysin.sportsnewsviewer.data.mappers.dtoToUI.MapNewsDetailsDTOToNewsItemUI
import o.mysin.sportsnewsviewer.data.mappers.dtoToUI.MapNewsItemDTOToNewsItemUI
import o.mysin.sportsnewsviewer.data.mappers.uiToEntity.MapNewsDetailUiToFavoriteNewsEntity
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val mappersDataModule = module {
    singleOf(::MapNewsDetailsDTOToNewsDetailsUI)
    singleOf(::MapNewsItemDTOToNewsItemUI)
    singleOf(::MapNewsDetailUiToFavoriteNewsEntity)
    singleOf(::MapNewsDetailsDTOToNewsItemUI)
}