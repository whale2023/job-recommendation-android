package kgb.plum.domain.repository

import kgb.plum.domain.model.CompanyModel
import kgb.plum.domain.model.EntityWrapper

interface RecruitRepository {
  suspend fun addWishList(jobAnnouncementId: Int): Int
  suspend fun deleteWishList(jobAnnouncementId: Int): Int
  suspend fun getRecruitList(page: Int, sort: String): EntityWrapper<List<CompanyModel>>
}