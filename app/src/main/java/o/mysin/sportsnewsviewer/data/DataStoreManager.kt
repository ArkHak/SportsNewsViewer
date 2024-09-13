package o.mysin.sportsnewsviewer.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class DataStoreManager(context: Context) {
    private val Context.datastore by preferencesDataStore(DATA_STORE_NAME)
    private val datastore = context.datastore

    val isDarkTheme: Flow<Boolean>
        get() = datastore.data.map { pref ->
            pref[isDarkThemeKey] ?: false
        }

    suspend fun setIsDarkTheme(isDark: Boolean) {
        datastore.edit { pref ->
            pref[isDarkThemeKey] = isDark
        }
    }

    companion object {
        private const val DATA_STORE_NAME = "DATA_STORE_SPORTS_NEWS"
        private const val IS_DARK_THEME_KEY = "IS_DARK_THEME_PREF"
        private val isDarkThemeKey = booleanPreferencesKey(name = IS_DARK_THEME_KEY)
    }
}