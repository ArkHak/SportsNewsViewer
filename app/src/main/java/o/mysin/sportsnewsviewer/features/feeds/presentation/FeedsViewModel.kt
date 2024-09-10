package o.mysin.sportsnewsviewer.features.feeds.presentation

import o.mysin.sportsnewsviewer.base.BaseViewModel
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsAction
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsEvent
import o.mysin.sportsnewsviewer.features.feeds.presentation.models.FeedsViewState

internal class FeedsViewModel :
    BaseViewModel<FeedsViewState, FeedsAction, FeedsEvent>(initialState = FeedsViewState()) {
    override fun obtainEvent(viewEvent: FeedsEvent) {
        when (viewEvent) {
            FeedsEvent.FeedClicked -> feedClicked()
        }
    }

    private fun feedClicked() {
        viewAction = FeedsAction.OpenDetailFeedScreen
    }

}