package kgb.plum.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.usecase.HomeUseCase
import kgb.plum.domain.model.RankItem
import kgb.plum.domain.model.WishItemData
import kgb.plum.domain.model.state.RankState
import kgb.plum.domain.model.state.UserState
import kgb.plum.domain.model.state.WishState
import kgb.plum.domain.usecase.WishUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeUseCase: HomeUseCase, private val wishUseCase: WishUseCase) : ViewModel() {

    private val _rankState: MutableStateFlow<RankState> = MutableStateFlow(RankState.Loading)
    val rankState: StateFlow<RankState> = _rankState

    private val _userState: MutableStateFlow<UserState> = MutableStateFlow(UserState.Loading)
    val userState: StateFlow<UserState> = _userState

    private val _wishState: MutableStateFlow<WishState> = MutableStateFlow(WishState.Loading)
    val wishState: StateFlow<WishState> = _wishState



    val popularCompany = mutableStateListOf<RankItem>()

    init {
        //getRankItemList()
        getUserInfo()
        //getPopularCompany()
        getWishList()
    }

    private fun getPopularCompany(){
        popularCompany.addAll(homeUseCase.getPopularCompany())
    }


    private fun getWishList() {
        viewModelScope.launch {
            _wishState.value = WishState.Loading
            val result = wishUseCase.getWishList()
            _wishState.value = when(result) {
                is EntityWrapper.Success -> {
                    WishState.Main(
                        wishList = result.entity
                    )
                }
                is EntityWrapper.Fail -> {
                    WishState.Failed(
                        reason = result.error.message ?: "Unknown error"
                    )
                }
            }
        }
    }

    private fun getRankItemList() {
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

    private fun getUserInfo() {
        viewModelScope.launch {
            _userState.value = UserState.Loading
            val result = homeUseCase.getUserInfo()
            _userState.value = when(result){
                200 -> {
                    UserState.Main
                }
                400 -> {
                    UserState.Fail
                }
                else -> {
                    UserState.Fail
                }
            }
        }
    }

    fun resetUserState() {
        _userState.value = UserState.Loading
    }


}