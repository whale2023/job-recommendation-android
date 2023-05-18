package kgb.plum.data.datasource

import kgb.plum.domain.model.ExModel
import javax.inject.Inject

class ExDataSource @Inject constructor() {

    fun getUserInfo() : ExModel {
        return ExModel(
            id = 1,
            name = "박준식",
            age = 25
        )
    }
}