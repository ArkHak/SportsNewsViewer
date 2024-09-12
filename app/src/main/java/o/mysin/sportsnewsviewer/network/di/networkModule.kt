package o.mysin.sportsnewsviewer.network.di

import o.mysin.sportsnewsviewer.network.NetworkApi
import org.koin.dsl.module

val networkModule = module {
    single { NetworkApi.create() }
}