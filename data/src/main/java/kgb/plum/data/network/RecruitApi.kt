package kgb.plum.data.network

import kgb.plum.data.library.model.ApiResult
import kgb.plum.data.model.CompanyResponse
import kgb.plum.domain.model.CompanyModel
import okhttp3.ResponseBody

interface RecruitApi {
  suspend fun addWishList(jobAnnouncementId: Int) : ApiResult<ResponseBody>
  suspend fun deleteWishList(jobAnnouncementId: Int) : ApiResult<ResponseBody>
  suspend fun getRecruitList(page: Int, sort: String): ApiResult<List<CompanyResponse>>
}