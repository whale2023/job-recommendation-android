package kgb.plum.presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kgb.plum.domain.usecase.HomeUseCase
import kgb.plum.domain.model.RecruitRankItem
import kgb.plum.domain.model.WishItemData
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeUseCase: HomeUseCase) : ViewModel() {

    val popularCompany = mutableStateListOf<RecruitRankItem>()
    val wishList = mutableStateListOf<WishItemData>()

    init {
        getPopularCompany()
        getWishList()
    }

    private fun getPopularCompany(){
        popularCompany.addAll(homeUseCase.getPopularCompany())
    }

    private fun getWishList(){
        wishList.addAll(homeUseCase.getWishList())
    }
}