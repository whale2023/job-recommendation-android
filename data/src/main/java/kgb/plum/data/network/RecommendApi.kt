package kgb.plum.data.network

import kgb.plum.data.library.model.ApiResult
import kgb.plum.data.model.CompanyResponse

interface RecommendApi {
    suspend fun getWishListBasedRecommendList(id: String) : ApiResult<List<CompanyResponse>>
}