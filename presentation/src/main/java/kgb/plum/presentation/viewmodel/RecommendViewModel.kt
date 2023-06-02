package kgb.plum.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kgb.plum.domain.model.RecommendItemData
import kgb.plum.domain.usecase.RecommendUseCase
import javax.inject.Inject

@HiltViewModel
class RecommendViewModel @Inject constructor(private val recommendUseCase: RecommendUseCase) : ViewModel()  {
    val recommendList = mutableListOf<RecommendItemData>()

    init {
        getRecommendList()
    }

    private fun getRecommendList() {
        recommendList.addAll(recommendUseCase.getRecommendList())
    }
}