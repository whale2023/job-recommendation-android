package kgb.plum.data.repository

import android.util.Log
import kgb.plum.data.mapper.RecruitMapper
import kgb.plum.data.network.RecruitApi
import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.repository.RecruitRepository
import javax.inject.Inject

class RecruitRepositoryImpl @Inject constructor(
  private val recruitApi: RecruitApi,
  private val recruitMapper: RecruitMapper
) : RecruitRepository {
  override suspend fun getRecruitList(page: Int, sort: String): EntityWrapper<List<CompanyModel>> {
    return recruitMapper.mapFromResult(result = recruitApi.getRecruitList(page, sort))
  }

  override suspend fun addWishList(jobAnnouncementId: Int): Int {
    val result = recruitApi.addWishList(jobAnnouncementId)
    Log.d("RecruitRepositoryImpl.addWishList()", result.code.toString())
    return result.code
  }

  override suspend fun deleteWishList(jobAnnouncementId: Int): Int {
    val result = recruitApi.deleteWishList(jobAnnouncementId)
    Log.d("RecruitRepositoryImpl.addWishList()", result.code.toString())
    return result.code
  }
}