package o.mysin.sportsnewsviewer.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope
import o.mysin.sportsnewsviewer.R
import o.mysin.sportsnewsviewer.database.entity.FavoriteNewsEntity
import o.mysin.sportsnewsviewer.database.mapper.FavoriteNewsEntityMapperImpl

@Database(entities = [FavoriteNewsEntity::class], version = 1)
abstract class SportNewsDatabase : RoomDatabase() {

    abstract fun favoriteNewsDao(): FavoriteNewsDao

    companion object {
        @Volatile
        private var Instance: SportNewsDatabase? = null

        fun getDatabase(
            context: Context,
            coroutineScope: CoroutineScope,
            mapper: FavoriteNewsEntityMapperImpl,
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

//@Database(entities = [User::class], version = 1)
//abstract class AppDatabase : RoomDatabase() {
//    abstract fun userDao(): UserDao
//}

//@Database(entities = [TaskEntity::class], version = 1, exportSchema = false)
//abstract class DiaryDatabase() : RoomDatabase() {
//
//    abstract fun taskDao(): TaskDao
//
//    companion object {
//        @Volatile
//        private var Instance: DiaryDatabase? = null
//
//        fun getDatabase(
//            context: Context,
//            coroutineScope: CoroutineScope,
//            mapper: TaskMapper,
//        ): DiaryDatabase {
//            return Instance ?: synchronized(this) {
//                Room.databaseBuilder(
//                    context,
//                    DiaryDatabase::class.java,
//                    context.getString(R.string.database_name)
//                )
//                    .fallbackToDestructiveMigration()
//                    .build()
//                    .apply {
//                        coroutineScope.launch {
//                            val listGson = getInitializationTasks(context)
//                            val list = mapper.toEntityTask(listGson)
//                            taskDao().insertList(list)
//                        }
//                    }
//                    .also { Instance = it }
//            }
//        }
//    }
//}
//
//private fun getInitializationTasks(context: Context): List<TaskFromJson> {
//    val inputStream: InputStream = context.assets.open(context.getString(R.string.assets_file_json))
//    val size: Int = inputStream.available()
//    val buffer = ByteArray(size)
//    inputStream.read(buffer)
//    inputStream.close()
//
//    val json = String(buffer, Charsets.UTF_8)
//
//    val gson = Gson()
//    val taskListType = object : TypeToken<List<TaskFromJson>>() {}.type
//    return gson.fromJson(json, taskListType)
//}