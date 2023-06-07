package kgb.plum.data.repository

import android.util.Log
import kgb.plum.data.datasource.WishDataSource
import kgb.plum.data.library.model.ApiResponse
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
    private val wishApi: WishApi,
    private val wishMapper: WishMapper
    ) :WishRepository {

    override suspend fun getWishList(): EntityWrapper<List<CompanyModel>> {
        return wishMapper.mapFromResult(
            result = wishApi.getWishList()
        )
    }

    override suspend fun addWishItem(jobAnnouncementId: Int): Int {
        val result = wishApi.addWishItem(jobAnnouncementId)
        return result.code
        }

    override suspend fun deleteWishItem(jobAnnouncementId: Int): Int {
        val result = wishApi.deleteWishItem(jobAnnouncementId)
        return result.code
    }
}



