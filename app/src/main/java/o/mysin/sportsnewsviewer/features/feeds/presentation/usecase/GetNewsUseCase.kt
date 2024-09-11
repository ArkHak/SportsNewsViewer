package o.mysin.sportsnewsviewer.features.feeds.presentation.usecase

import o.mysin.sportsnewsviewer.data.NewsRepository

class GetNewsUseCase(
    private val repository: NewsRepository,
) {
    suspend operator fun invoke() = repository.getNews()
}

//class BookTripUseCase(
//    private val repository: HomePassengerRepository,
//) {
//    suspend operator fun invoke(bookingTripInfo: BookingTripInfo) =
//        repository.bookTrip(bookingTripInfo)
//}