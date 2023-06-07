package kgb.plum.data.datasource

import com.google.gson.reflect.TypeToken
import kgb.plum.data.library.model.ApiResult
import kgb.plum.data.library.model.NetworkRequestInfo
import kgb.plum.data.library.model.RequestType
import kgb.plum.data.library.retrofit.NetworkRequestFactory
import kgb.plum.data.network.MyPageApi
import kgb.plum.domain.LoginTokenData
import kgb.plum.domain.model.CareerModel
import kgb.plum.domain.model.ResumeModel
import kgb.plum.domain.model.UserInfoModel
import javax.inject.Inject

class MyPageDataSource @Inject constructor(
  private val networkRequestFactory: NetworkRequestFactory
): MyPageApi {
  override suspend fun saveResume(resumeModel: ResumeModel): ApiResult<ResumeModel> {
    return networkRequestFactory.create(
      url = "resumes",
      type = object : TypeToken<ResumeModel>(){}.type,
      requestInfo = NetworkRequestInfo.Builder(RequestType.POST).withHeaders(mapOf("Authorization" to "Bearer ${LoginTokenData.atk}")).build()
    )
  }

  override suspend fun getResume(): ApiResult<ResumeModel> {
    return networkRequestFactory.create(
      url = "resumes",
      type = object : TypeToken<ResumeModel>(){}.type,
      requestInfo = NetworkRequestInfo.Builder(RequestType.GET).withHeaders(mapOf("Authorization" to "Bearer ${LoginTokenData.atk}")).build()
    )
  }
}