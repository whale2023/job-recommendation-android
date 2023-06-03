package kgb.plum.domain.model

data class RecommendItemData(
    val id: Int,
    val company: String,
    val occupation: String,
    val recommendReason: List<String>,
    val score: Double
)
