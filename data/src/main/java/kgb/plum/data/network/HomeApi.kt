package kgb.plum.data.network

import kgb.plum.data.library.model.ApiResult
import kgb.plum.data.model.CompanyResponse
import kgb.plum.domain.model.EntityWrapper

interface HomeApi {
    suspend fun getRankItemList(): ApiResult<List<CompanyResponse>>
}