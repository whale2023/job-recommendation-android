package kgb.plum.data.mapper

import kgb.plum.data.model.LoginResponse
import kgb.plum.data.model.SignUpRequest
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.LoginToken
import javax.inject.Inject

class LoginMapper @Inject constructor(

) : BaseMapper<LoginResponse, LoginToken>() {

    override fun getSuccess(model: LoginResponse?, extra: Any?): EntityWrapper.Success<LoginToken> {
        return model?.let {
            EntityWrapper.Success(
                LoginToken(
                    model.atk,
                    model.rtk
                )
            )
        } ?: EntityWrapper.Success(
            LoginToken()
        )
    }


    override fun getFailure(error: Throwable): EntityWrapper.Fail<LoginToken> {
        return EntityWrapper.Fail(error)
    }
}