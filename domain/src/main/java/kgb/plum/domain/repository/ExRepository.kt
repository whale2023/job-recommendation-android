package kgb.plum.domain.repository

import kgb.plum.domain.model.ExModel

interface ExRepository {

    fun getUserInfo() : ExModel
}