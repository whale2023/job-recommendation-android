package kgb.plum.domain.usecase

import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.model.EntityWrapper
import kgb.plum.domain.repository.RecruitRepository
import javax.inject.Inject

class RecruitUseCase @Inject constructor(private val recruitRepository: RecruitRepository) {
  suspend fun getRecruitList(page:Int, sort: String): EntityWrapper<List<CompanyModel>> {
    return this.recruitRepository.getRecruitList(page, sort)
  }

  suspend fun changeIsWished(companyId: Int, isWished: Boolean) {
    if(!isWished) recruitRepository.addWishList(companyId)
    else recruitRepository.deleteWishList(companyId)
  }
}