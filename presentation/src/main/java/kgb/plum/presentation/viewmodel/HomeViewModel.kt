package kgb.plum.presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.usecase.HomeUseCase
import kgb.plum.domain.model.RankItem
import kgb.plum.domain.model.WishItemData
import kgb.plum.presentation.model.state.RankState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeUseCase: HomeUseCase) : ViewModel() {

    private val _rankState: MutableStateFlow<RankState> =
        MutableStateFlow(RankState.Loading)
    val rankState: StateFlow<RankState> = _rankState



    val popularCompany = mutableStateListOf<RankItem>()
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

    suspend fun getRankItemList() {
        viewModelScope.launch {
            _rankState.value = RankState.Loading
            val rankItems = homeUseCase.getRankItemList()
            _rankState.value = when(rankItems) {
                is EntityWrapper.Success -> {
                    RankState.Main(
                        rankList = rankItems.entity
                    )
                }
                is EntityWrapper.Fail -> {
                    RankState.Failed(
                        reason = rankItems.error.message ?: "Unknown Error"
                    )
                }
            }
        }
    }
}