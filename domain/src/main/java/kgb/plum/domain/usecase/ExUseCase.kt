package kgb.plum.domain.usecase

import kgb.plum.domain.model.ExModel
import kgb.plum.domain.repository.ExRepository
import javax.inject.Inject

class ExUseCase @Inject constructor(private val exRepository: ExRepository) {

    fun getUserInfo() : ExModel {
        return exRepository.getUserInfo()
    }
}