package kgb.plum.data.datasource

import kgb.plum.domain.model.RecruitModel
import javax.inject.Inject

class RecruitDataSource @Inject constructor()  {
  fun getRecruitList(): List<RecruitModel> {
    return listOf<RecruitModel>(
      RecruitModel(
        title = "Title",
        company = "Company",
        tag = listOf("Tag", "Tag", "Tag"),
        isWished = false,
      ),
      RecruitModel(
        title = "Title",
        company = "Company",
        tag = listOf("Tag", "Tag", "Tag"),
        isWished = false,
      )
    )
  }
}