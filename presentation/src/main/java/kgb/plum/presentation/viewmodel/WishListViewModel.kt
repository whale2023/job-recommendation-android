package kgb.plum.presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kgb.plum.domain.model.WishItemData
import kgb.plum.domain.usecase.WishUseCase
import javax.inject.Inject

@HiltViewModel
class WishListViewModel @Inject constructor(private val wishUseCase: WishUseCase) : ViewModel() {
    val wishList = mutableStateListOf<WishItemData>()

    init {
        getWishList()
    }

    private fun getWishList(){
        wishList.addAll(wishUseCase.getWishList())
    }
}