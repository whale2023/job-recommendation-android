package kgb.plum.data.datasource

import com.google.gson.reflect.TypeToken
import kgb.plum.data.library.model.ApiResult
import kgb.plum.data.library.model.NetworkRequestInfo
import kgb.plum.data.library.model.RequestType
import kgb.plum.data.library.retrofit.NetworkRequestFactory
import kgb.plum.data.model.CompanyResponse
import kgb.plum.data.network.WishApi
import kgb.plum.domain.LoginTokenData
import okhttp3.ResponseBody
import javax.inject.Inject

class WishDataSource @Inject constructor(
  private val networkRequestFactory: NetworkRequestFactory
) : WishApi {



  fun getWishListItem(): List<CompanyResponse> {
    return emptyList()
  }

  override suspend fun addWishItem(
  ): ApiResult<ResponseBody> {
    return networkRequestFactory.create(
      url = "wish",
      type = object: TypeToken<ResponseBody>(){}.type,
      requestInfo = NetworkRequestInfo.Builder(RequestType.POST).withHeaders(mapOf("Authorization" to "Bearer ${LoginTokenData.atk}")).build()
    )
  }

  override suspend fun deleteWishItem(

  ): ApiResult<ResponseBody> {
    return networkRequestFactory.create(
      url = "wish",
      type = object: TypeToken<ResponseBody>(){}.type,
      requestInfo = NetworkRequestInfo.Builder(RequestType.DELETE).withHeaders(mapOf("Authorization" to "Bearer ${LoginTokenData.atk}")).build()
    )
  }

  override suspend fun getWishList(): ApiResult<List<CompanyResponse>> {
    return networkRequestFactory.create(
      url = "wish",
      type = object: TypeToken<CompanyResponse>(){}.type,
      requestInfo = NetworkRequestInfo.Builder().withHeaders(mapOf("Authorization" to "Bearer ${LoginTokenData.atk}")).build()
    )
  }
}