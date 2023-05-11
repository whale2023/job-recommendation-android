package kumoh.whale.whale.model.repository

import androidx.compose.runtime.mutableStateListOf
import kumoh.whale.whale.model.entity.RecruitEntity

object RecruitRepository {
  val recruitList = mutableStateListOf<RecruitEntity>(
    RecruitEntity(
      title = "Title",
      company = "Company",
      tag = listOf("Tag", "Tag", "Tag"),
      isWished = false,
    ),
    RecruitEntity(
      title = "Title",
      company = "Company",
      tag = listOf("Tag", "Tag", "Tag"),
      isWished = false,
    )
  )
}