package kgb.plum.data.datasource

import kgb.plum.domain.model.RecruitRankItem
import kgb.plum.domain.model.WishItemData
import kotlinx.coroutines.flow.MutableStateFlow

class HomeDataSource {
    val recruitRankItems = listOf(
        RecruitRankItem(1, null, "금오컴퍼니", "사무직"),
        RecruitRankItem(2, null, "대광스카이", "영업직"),
        RecruitRankItem(3, null, "삼성 전자", "기술팀"),
        RecruitRankItem(4, null, "LG CNS", "PM"),
        RecruitRankItem(5, null, "금오사이", "프론트엔드"),
        RecruitRankItem(6, null, "대한항공", "마케팅"),
        RecruitRankItem(7, null, "금오 건설", "현장 지휘"),
        RecruitRankItem(8, null, "금오 전자", "기술 연구"),
        RecruitRankItem(9, null, "알바몬", "인사직"),
        RecruitRankItem(10, null, "당근마켓", "백엔드")
    )

    fun getPopularCompany() : List<RecruitRankItem>{
        return recruitRankItems
    }

    fun getWishList() : List<WishItemData> {
        return emptyList()
    }
}