package kgb.plum.data.network

import kgb.plum.data.library.model.ApiResult
import kgb.plum.data.model.CompanyResponse
import okhttp3.ResponseBody

interface WishApi {
    suspend fun addWishItem() : ApiResult<ResponseBody>
    suspend fun deleteWishItem() : ApiResult<ResponseBody>
    suspend fun getWishList() : ApiResult<List<CompanyResponse>>
}