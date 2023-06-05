package kgb.plum.data.mapper

import kgb.plum.data.library.model.ApiResult
import kgb.plum.data.model.CompanyResponse
import kgb.plum.data.model.SignUpRequest
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.RankItem
import javax.inject.Inject

class SignUpMapper @Inject constructor(

) : BaseMapper<SignUpRequest, Int>() {
 
    override fun getSuccess(model: SignUpRequest?, extra: Any?): EntityWrapper.Success<Int> {
        return model?.let {
            EntityWrapper.Success(
                500
            )
        } ?: EntityWrapper.Success(
            entity = 400
        )
    }
    

    override fun getFailure(error: Throwable): EntityWrapper.Fail<Int> {
        return EntityWrapper.Fail(error)
    }
}