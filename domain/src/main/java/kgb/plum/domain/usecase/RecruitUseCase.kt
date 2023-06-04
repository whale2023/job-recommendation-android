package kgb.plum.domain.usecase

import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.model.RecruitModel
import kgb.plum.domain.repository.RecruitRepository
import javax.inject.Inject

class RecruitUseCase @Inject constructor(private val recruitRepository: RecruitRepository) {
  fun getRecruitList(): List<CompanyModel> {
    return this.recruitRepository.getRecruitList()
  }

  fun changeIsWished(companyModel: CompanyModel) {
    if(!companyModel.addedWishlist) recruitRepository.addWishList(companyModel.id)
    else recruitRepository.deleteWishList(companyModel.id)
  }
}