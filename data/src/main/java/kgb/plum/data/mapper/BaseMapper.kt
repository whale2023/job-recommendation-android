package kgb.plum.data.mapper

import kgb.plum.data.library.model.ApiResponse
import kgb.plum.data.library.model.ApiResult
import kgb.plum.domain.model.EntityWrapper

abstract class BaseMapper<M, E> {

    fun mapFromResult(result: ApiResult<M>, extra: Any? = null): EntityWrapper<E> =
        when (result.response) {
            is ApiResponse.Success -> getSuccess(model = result.response.data, extra = extra)
            is ApiResponse.Fail -> getFailure(error = result.response.error)
        }

    fun getCode(result: ApiResult<M>, extra: Any? = null): EntityWrapper<Int> =
        when (result.response) {
            is ApiResponse.Success -> EntityWrapper.Success(result.code)
            is ApiResponse.Fail -> EntityWrapper.Success(404)
        }

    abstract fun getSuccess(model: M?, extra: Any?): EntityWrapper.Success<E>

    abstract fun getFailure(error: Throwable): EntityWrapper.Fail<E>
}