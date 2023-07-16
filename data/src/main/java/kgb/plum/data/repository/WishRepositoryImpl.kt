package kgb.plum.data.repository

import android.util.Log
import kgb.plum.data.mapper.CompanyMapper
import kgb.plum.data.network.WishApi
import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.repository.WishRepository
import javax.inject.Inject

class WishRepositoryImpl @Inject constructor(
    private val wishApi: WishApi,
    private val companyMapper: CompanyMapper
    ) :WishRepository {

    override suspend fun getWishList(): EntityWrapper<List<CompanyModel>> {
        return companyMapper.mapFromResult(
            result = wishApi.getWishList()
        )
    }

    override suspend fun addWishItem(jobAnnouncementId: Int): Int {
        val result = wishApi.addWishItem(jobAnnouncementId)
        return result.code
        }

    override suspend fun deleteWishItem(jobAnnouncementId: Int): Int {
        val result = wishApi.deleteWishItem(jobAnnouncementId)
        Log.d("테스트", "result.toString()")
        return result.code
    }
}



