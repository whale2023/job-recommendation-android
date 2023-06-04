package kgb.plum.data.repository

import kgb.plum.data.datasource.RecruitDataSource
import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.repository.RecruitRepository
import javax.inject.Inject

class RecruitRepositoryImpl @Inject constructor(private val recruitDataSource: RecruitDataSource) : RecruitRepository {
  override fun getRecruitList(): List<CompanyModel> {
    return recruitDataSource.getRecruitList()
  }

  override fun addWishList(companyModelId: Int) {
    recruitDataSource.addWishList(companyModelId)
  }

  override fun deleteWishList(companyModelId: Int) {
    recruitDataSource.deleteWishList(companyModelId)
  }
}