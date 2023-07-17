package kgb.plum.data.datasource

import com.google.gson.reflect.TypeToken
import kgb.plum.data.library.model.ApiResult
import kgb.plum.data.library.model.NetworkRequestInfo
import kgb.plum.data.library.model.RequestType
import kgb.plum.data.library.retrofit.NetworkRequestFactory
import kgb.plum.data.network.RecruitApi
import kgb.plum.domain.LoginTokenData
import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.model.RecruitModel
import kgb.plum.domain.model.ResumeModel
import okhttp3.ResponseBody
import javax.inject.Inject

class RecruitDataSource @Inject constructor(
  private val networkRequestFactory: NetworkRequestFactory
): RecruitApi  {
  override suspend fun getRecruitList(page: Int, sort: String): ApiResult<List<CompanyModel>> {
    return networkRequestFactory.create(
      url = "announcement?page=${page}&size=10&sort=id,$sort",
      type = object : TypeToken<List<CompanyModel>>(){}.type,
      requestInfo = NetworkRequestInfo.Builder(RequestType.GET).withHeaders(mapOf("Authorization" to "Bearer ${LoginTokenData.atk}")).build()
    )
  }

  override suspend fun addWishList(jobAnnouncementId: Int): ApiResult<ResponseBody> {
    return networkRequestFactory.create(
      url = "announcement/wish?jobAnnoucemnetId=${jobAnnouncementId}",
      type = object: TypeToken<ResponseBody>(){}.type,
      requestInfo = NetworkRequestInfo.Builder(RequestType.POST).withHeaders(mapOf("Authorization" to "Bearer ${LoginTokenData.atk}")).build()
    )
  }

  override suspend fun deleteWishList(jobAnnouncementId: Int): ApiResult<ResponseBody> {
    return networkRequestFactory.create(
      url = "announcement/wish?jobAnnoucemnetId=${jobAnnouncementId}",
      type = object: TypeToken<ResponseBody>(){}.type,
      requestInfo = NetworkRequestInfo.Builder(RequestType.DELETE).withHeaders(mapOf("Authorization" to "Bearer ${LoginTokenData.atk}")).build()
    )
  }
}