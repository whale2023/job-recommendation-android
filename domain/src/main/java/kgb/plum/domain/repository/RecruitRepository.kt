package kgb.plum.domain.repository

import kgb.plum.domain.model.CompanyModel

interface RecruitRepository {
  fun getRecruitList(): List<CompanyModel>

  fun addWishList(companyModelId: Int)
  fun deleteWishList(companyModelId: Int)
}