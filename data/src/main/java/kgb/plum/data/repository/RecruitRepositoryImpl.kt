package kgb.plum.data.repository

import kgb.plum.data.datasource.RecruitDataSource
import kgb.plum.domain.model.RecruitModel
import kgb.plum.domain.repository.RecruitRepository
import javax.inject.Inject

class RecruitRepositoryImpl @Inject constructor(private val recruitDataSource: RecruitDataSource) : RecruitRepository {
  override fun getRecruitList(): List<RecruitModel> {
    return recruitDataSource.getRecruitList()
  }
}