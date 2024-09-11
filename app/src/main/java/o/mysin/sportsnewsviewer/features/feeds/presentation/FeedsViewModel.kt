package o.mysin.sportsnewsviewer.features.feeds.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import o.mysin.sportsnewsviewer.base.BaseViewModel
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsAction
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsEvent
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsViewState
import o.mysin.sportsnewsviewer.features.feeds.presentation.usecase.GetNewsUseCase

internal class FeedsViewModel(
    private val getNewsUseCase: GetNewsUseCase,
) :
    BaseViewModel<FeedsViewState, FeedsAction, FeedsEvent>(initialState = FeedsViewState()) {
    override fun obtainEvent(viewEvent: FeedsEvent) {
        when (viewEvent) {
            FeedsEvent.FeedClicked -> feedClicked()
        }
    }

    private fun feedClicked() {
        viewModelScope.launch {
            val ssss= getNewsUseCase.invoke()
            Log.d("aaaaa", "feedClicked: ${ssss}")
        }



        viewAction = FeedsAction.OpenDetailFeedScreen
    }

}