package kgb.plum.data.repository

import kgb.plum.data.datasource.ExDataSource
import kgb.plum.domain.model.ExModel
import kgb.plum.domain.repository.ExRepository
import javax.inject.Inject

class ExRepositoryImpl @Inject constructor(private val exDataSource: ExDataSource): ExRepository {
    override fun getUserInfo(): ExModel {
        return exDataSource.getUserInfo()
    }
}