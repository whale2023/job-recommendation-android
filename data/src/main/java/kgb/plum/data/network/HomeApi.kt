package kgb.plum.data.network

import kgb.plum.data.library.model.ApiResult

interface HomeApi {
    suspend fun retrofitTest(): ApiResult<List<TestResponse>>
}