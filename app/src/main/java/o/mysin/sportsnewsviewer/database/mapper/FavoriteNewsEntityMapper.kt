package o.mysin.sportsnewsviewer.database.mapper

import o.mysin.sportsnewsviewer.data.model.NewsDetailsUI
import o.mysin.sportsnewsviewer.database.entity.FavoriteNewsEntity

interface FavoriteNewsEntityMapper {
    fun toFavoriteNewsEntity(data: NewsDetailsUI): FavoriteNewsEntity
}


//class TaskMapper : ITaskMapper {
//    override fun toDataTask(data: TaskEntity): Task =
//        Task(
//            id = data.id,
//            dateStart = data.dateStart,
//            dateFinish = data.dateFinish,
//            name = data.name,
//            description = data.description
//        )
//
//    override fun toDataTask(data: TaskFromJson): Task =
//        Task(
//            id = data.id,
//            dateStart = data.dateStart,
//            dateFinish = data.dateFinish,
//            name = data.name,
//            description = data.description
//        )
//
//    override fun toDataTask(dataList: List<TaskEntity>): List<Task> =
//        dataList.map { task ->
//            toDataTask(task)
//        }
//
//    override fun toEntityTask(data: TaskFromJson): TaskEntity =
//        TaskEntity(
//            id = data.id,
//            dateStart = data.dateStart,
//            dateFinish = data.dateFinish,
//            name = data.name,
//            description = data.description
//        )
//
//    override fun toEntityTask(data: Task): TaskEntity =
//        TaskEntity(
//            id = data.id,
//            dateStart = data.dateStart,
//            dateFinish = data.dateFinish,
//            name = data.name,
//            description = data.description
//        )
//
//    override fun toEntityTask(dataList: List<TaskFromJson>): List<TaskEntity> =
//        dataList.map { task ->
//            toEntityTask(task)
//        }
//}