package kgb.plum.domain.model

data class RecruitModel(
  val title: String,
  val company: String,
  val tag: List<String>,
  val isWished: Boolean,
)