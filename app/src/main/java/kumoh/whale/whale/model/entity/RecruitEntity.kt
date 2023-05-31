package kumoh.whale.whale.model.entity

data class RecruitEntity(
  val title: String,
  val company: String,
  val tag: List<String>,
  val isWished: Boolean,
)