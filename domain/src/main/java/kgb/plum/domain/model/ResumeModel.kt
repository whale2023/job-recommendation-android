package kgb.plum.domain.model

data class ResumeModel(
  val major: String,
  val education: String,
  val preferIncome: Long,
  val workType: String,
  val certifications: List<String>,
  val careers: List<CareerModel>,
  val preferKeywords: List<String>,
  val preferJob: String
)