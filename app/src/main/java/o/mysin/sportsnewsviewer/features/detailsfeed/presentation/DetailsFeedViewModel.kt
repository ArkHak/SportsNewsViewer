package o.mysin.sportsnewsviewer.features.detailsfeed.presentation

import o.mysin.sportsnewsviewer.base.BaseViewModel
import o.mysin.sportsnewsviewer.features.detailsfeed.presentation.models.DetailsFeedAction
import o.mysin.sportsnewsviewer.features.detailsfeed.presentation.models.DetailsFeedEvent
import o.mysin.sportsnewsviewer.features.detailsfeed.presentation.models.DetailsFeedViewState


internal class DetailsFeedViewModel :
    BaseViewModel<DetailsFeedViewState, DetailsFeedAction, DetailsFeedEvent>(initialState = DetailsFeedViewState()) {
    override fun obtainEvent(viewEvent: DetailsFeedEvent) {
        when (viewEvent) {
            DetailsFeedEvent.ArrowBackPressed -> arrowBackPressed()
        }
    }

    private fun arrowBackPressed() {
        viewAction = DetailsFeedAction.BackMainScreen
    }

}