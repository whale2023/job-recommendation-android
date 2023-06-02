package kgb.plum.domain.repository

import kgb.plum.domain.model.RecruitModel

interface RecruitRepository {
  fun getRecruitList(): List<RecruitModel>
}