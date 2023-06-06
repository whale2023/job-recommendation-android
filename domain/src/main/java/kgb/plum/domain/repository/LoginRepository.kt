package kgb.plum.domain.repository

import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.model.LoginToken

interface LoginRepository {
    suspend fun login(id: String, pw: String) : EntityWrapper<LoginToken>
}