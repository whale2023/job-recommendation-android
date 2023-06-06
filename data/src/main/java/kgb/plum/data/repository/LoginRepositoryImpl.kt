package kgb.plum.data.repository

import kgb.plum.data.mapper.LoginMapper
import kgb.plum.data.network.LoginApi
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.LoginToken
import kgb.plum.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginApi: LoginApi,
    private val loginMapper: LoginMapper
) : LoginRepository {
    override suspend fun login(id: String, pw: String): EntityWrapper<LoginToken> {
        val result = loginApi.login(email = id, password = pw)
        val mappingData = loginMapper.mapFromResult(result)
        if( mappingData is EntityWrapper.Success){
            mappingData.entity.code = result.code
        }
        return mappingData
    }

}