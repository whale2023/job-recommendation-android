package kgb.plum.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.RecommendItemData
import kgb.plum.domain.model.UserInfo
import kgb.plum.domain.model.state.WishRecommendState
import kgb.plum.domain.usecase.RecommendUseCase
import kgb.plum.domain.usecase.WishUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecommendViewModel @Inject constructor(private val recommendUseCase: RecommendUseCase, private val wishUseCase: WishUseCase) : ViewModel()  {
    val recommendList = mutableStateListOf<RecommendItemData>()
    private val _wishListBaseRecommendState: MutableStateFlow<WishRecommendState> = MutableStateFlow(WishRecommendState.Loading)
    val wishListBaseRecommendState : StateFlow<WishRecommendState> = _wishListBaseRecommendState

    init {
        getRecommendList()
    }

    private fun getRecommendList() {
        recommendList.addAll(recommendUseCase.getRecommendList())
    }

    fun changeWishStatus(isWish: Boolean, id: Int){
        viewModelScope.launch {
            if(isWish){
                wishUseCase.addWishItem(id)
            }else{
                wishUseCase.deleteWishItem(id)
            }
        }
    }

    fun getWishListBaseRecommend(){
        viewModelScope.launch {
            _wishListBaseRecommendState.value = WishRecommendState.Loading
            val result = recommendUseCase.getWishListBaseRecommend(UserInfo.userData?.email ?:"")
            if(result is EntityWrapper.Success){
                Log.d("테스트", result.entity.toString())
            }
        }
    }
}