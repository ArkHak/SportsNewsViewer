package o.mysin.sportsnewsviewer.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import o.mysin.sportsnewsviewer.R
import o.mysin.sportsnewsviewer.database.entity.FavoriteNewsEntity

@Database(entities = [FavoriteNewsEntity::class], version = 1)
abstract class SportNewsDatabase : RoomDatabase() {

    abstract fun favoriteNewsDao(): FavoriteNewsDao

    companion object {
        @Volatile
        private var Instance: SportNewsDatabase? = null

        fun getDatabase(
            context: Context,
        ): SportNewsDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    SportNewsDatabase::class.java,
                    context.getString(R.string.name_database)
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}