package kgb.plum.data.repository

import kgb.plum.data.datasource.WishDataSource
import kgb.plum.domain.model.WishItemData
import java.text.SimpleDateFormat
import java.util.Calendar
import javax.inject.Inject

class WishRepositoryImpl @Inject constructor(private val wishDataSource: WishDataSource) {
    fun getWishList() : List<WishItemData> {
        val list = wishDataSource.getWishList()
        val wishList = mutableListOf<WishItemData>()
        list.forEach{item ->
            wishList.add(WishItemData(item.companyName, item.recruitmentType, getDDay(item.deadLine),item.deadLine))
        }
        return wishList
    }

    fun getDDay(deadLine: String) : String {

        val dateFormat = SimpleDateFormat("yyyy-MM-dd")

        val endDate = dateFormat.parse(deadLine).time
        val today = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.time.time


        return if(today==endDate) "D-DAY" else "D${(today - endDate) / (24 * 60 * 60 * 1000)}"
    }
}