package kgb.plum.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kgb.plum.presentation.model.RecommendItemData
import kgb.plum.presentation.ui.common.RecommendItem
import kgb.plum.presentation.ui.theme.Padding
import kgb.plum.presentation.ui.theme.WhaleTheme
import kgb.plum.presentation.ui.theme.colors

@Composable
fun RecommendScreen() {
    val recommendItems = listOf(
        RecommendItemData(1, "금오컴퍼니", "사무직", listOf("10년 이상 무사고", "집이랑 가까워요", "연봉이 높아요", "주변에 건강 센터가 있어요"),82.6),
        RecommendItemData(2,"대광스카이", "영업직", listOf("10년 이상 무사고", "집이랑 가까워요", "연봉이 높아요", "주변에 건강 센터가 있어요"),78.8),
        RecommendItemData(3, "삼성 전자", "기술팀", listOf("10년 이상 무사고", "집이랑 가까워요", "연봉이 높아요", "주변에 건강 센터가 있어요"),76.2),
        RecommendItemData(4,"LG CNS", "PM", listOf("10년 이상 무사고", "집이랑 가까워요", "연봉이 높아요", "주변에 건강 센터가 있어요"),74.4),
        RecommendItemData(5,"금오사이", "프론트엔드", listOf("10년 이상 무사고", "집이랑 가까워요", "연봉이 높아요", "주변에 건강 센터가 있어요"),72.6),
        RecommendItemData(6,"대한항공", "마케팅", listOf("10년 이상 무사고", "집이랑 가까워요", "연봉이 높아요", "주변에 건강 센터가 있어요"),70.3),
        RecommendItemData(7,"금오 건설", "현장 지휘", listOf("10년 이상 무사고", "집이랑 가까워요", "연봉이 높아요", "주변에 건강 센터가 있어요"),68.7),
        RecommendItemData(8,"금오 전자", "기술 연구", listOf("10년 이상 무사고", "집이랑 가까워요", "연봉이 높아요", "주변에 건강 센터가 있어요"),66.9),
        RecommendItemData(9,"알바몬", "인사직", listOf("10년 이상 무사고", "집이랑 가까워요", "연봉이 높아요", "주변에 건강 센터가 있어요"),64.1),
        RecommendItemData(10,"당근마켓", "백엔드", listOf("10년 이상 무사고", "집이랑 가까워요", "연봉이 높아요", "주변에 건강 센터가 있어요"),62.7))

    Column(
        modifier = Modifier.background(MaterialTheme.colors.surface)
            .fillMaxSize()
            .padding(Padding.large)
    ){
        Text(
           text = "추천",
            style = MaterialTheme.typography.headlineSmall
        )
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Padding.medium),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                top = Padding.medium,
                bottom = Padding.medium
            )
        ){
            items(recommendItems) { item ->
                RecommendItem(
                    color = if(item.id%2==1) MaterialTheme.colors.background else MaterialTheme.colors.secondary,
                    company = item.company,
                    occupation = item.occupation,
                    recommendReason = item.recommendReason,
                    score = item.score
                )
            }
        }
    }
}

@Preview
@Composable
fun RecommendScreenPreview() {
    WhaleTheme {
        RecommendScreen()
    }
}