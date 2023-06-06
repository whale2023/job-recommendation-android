package kgb.plum.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.himanshoe.kalendar.KalendarEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.WishItemData
import kgb.plum.domain.model.state.WishState
import kgb.plum.domain.usecase.WishUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDate
import javax.inject.Inject

@HiltViewModel
class WishListViewModel @Inject constructor(private val wishUseCase: WishUseCase) : ViewModel() {
    val wishList = mutableStateListOf<WishItemData>()
    val eventList = mutableStateListOf<KalendarEvent>()

    private val _wishState: MutableStateFlow<WishState> = MutableStateFlow(WishState.Loading)
    val wishState: StateFlow<WishState> = _wishState

    init {
        getWishList()
    }

    private fun getWishListItem(){
        wishList.addAll(wishUseCase.getWishListItem())
    }

    private fun getWishList() {
        viewModelScope.launch {
            _wishState.value = WishState.Loading
            val result = wishUseCase.getWishList()
            _wishState.value = when(result) {
                is EntityWrapper.Success -> {
                    updateEventList()
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

    private fun updateEventList() {
        eventList.clear()
        if(_wishState.value is WishState.Main){
            (_wishState.value as WishState.Main).wishList.forEach {
                eventList.add(KalendarEvent(LocalDate.parse(it.recruitmentPeriod), it.companyName, it.companyName))
            }
        }
    }
}