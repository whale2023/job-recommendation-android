package kgb.plum.presentation.viewmodel

import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.himanshoe.kalendar.KalendarEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kgb.plum.domain.model.WishItemData
import kgb.plum.domain.usecase.WishUseCase
import kgb.plum.presentation.ui.theme.colors
import kotlinx.datetime.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class WishListViewModel @Inject constructor(private val wishUseCase: WishUseCase) : ViewModel() {
    val wishList = mutableStateListOf<WishItemData>()
    val eventList = mutableStateListOf<KalendarEvent>()

    init {
        getWishList()
    }

    private fun getWishList(){
        wishList.addAll(wishUseCase.getWishList())
        updateEventList()
    }

    private fun updateEventList() {
        eventList.clear()
        wishList.forEach {
            eventList.add(KalendarEvent(LocalDate.parse(it.deadLine), it.company, it.company))
            Log.d("테스트", eventList[0].toString())
        }
    }
}