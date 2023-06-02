package kgb.plum.domain.model

data class RecruitRankItem(
    val rank: Int,
    val image: String? = null,
    val company: String,
    val occupation: String
)
