package kgb.plum.domain.usecase

import kgb.plum.domain.model.RecruitModel
import kgb.plum.domain.repository.RecruitRepository
import javax.inject.Inject

class RecruitUseCase @Inject constructor(private val recruitRepository: RecruitRepository) {
  fun getRecruitList(): List<RecruitModel> {
    return this.recruitRepository.getRecruitList()
  }
}