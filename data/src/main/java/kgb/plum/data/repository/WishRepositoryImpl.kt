package kgb.plum.data.repository

import kgb.plum.data.datasource.WishDataSource
import kgb.plum.data.mapper.WishMapper
import kgb.plum.data.network.WishApi
import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.WishItemData
import kgb.plum.domain.repository.WishRepository
import java.text.SimpleDateFormat
import java.util.Calendar
import javax.inject.Inject

class WishRepositoryImpl @Inject constructor(
    private val wishDataSource: WishDataSource,
    private val wishApi: WishApi,
    private val wishMapper: WishMapper
    ) :WishRepository {
    override fun getWishListItem() : List<WishItemData> {
        val list = wishDataSource.getWishListItem()
        val wishList = mutableListOf<WishItemData>()
        list.forEach{item ->
            wishList.add(WishItemData(item.companyName, item.recruitmentType, getDDay(item.recruitmentPeriod),item.recruitmentPeriod))
        }
        return wishList
    }

    override suspend fun getWishList(): EntityWrapper<List<CompanyModel>> {
        return wishMapper.mapFromResult(
            result = wishApi.getWishList()
        )
    }

    private fun getDDay(deadLine: String) : String {

        val dateFormat = SimpleDateFormat("yyyy-MM-dd")

        val endDate = dateFormat.parse(deadLine).time
        val today = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.time.time


        return if(today==endDate) "D-DAY" else if (today>endDate) "D+${(today - endDate) / (24 * 60 * 60 * 1000)}" else "D${(today - endDate) / (24 * 60 * 60 * 1000)}"
    }


}