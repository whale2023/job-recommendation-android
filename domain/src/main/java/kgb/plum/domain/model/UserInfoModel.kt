package kgb.plum.domain.model

data class UserInfoModel(
  val username: String,
  val age: Int,
  val email: String,
  val addressInfo: String,
  val disabilityType: String
)