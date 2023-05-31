package kgb.plum.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kgb.plum.presentation.model.RecruitRankItem
import kgb.plum.presentation.ui.common.RecruitCardItem
import kgb.plum.presentation.ui.common.WishItem
import kgb.plum.presentation.ui.theme.Padding
import kgb.plum.presentation.ui.theme.WhaleTheme
import kgb.plum.presentation.ui.theme.colors
import kgb.plum.presentation.ui.theme.nameMedium

@Composable
fun HomeScreen(){
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
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.surface)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.
                    padding(Padding.extra)
        ){
            Row(
                verticalAlignment = Alignment.Bottom
            ){
                Text(
                    text = "박준식",
                    style = MaterialTheme.typography.nameMedium
                )
                Text(
                    text = "님 안녕하세요?",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(modifier = Modifier.size(24.dp))
            Text(
                text = "인기 채용 정보",
                style = MaterialTheme.typography.nameMedium
            )
            Spacer(modifier = Modifier.size(24.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(Padding.large),
                contentPadding = PaddingValues(
                    start = Padding.small,
                    end = Padding.small
                )
            ){
                items(recruitRankItems, key = {it.rank}) { item ->
                    RecruitCardItem(rank = item.rank, company = item.company, occupation = item.occupation)
                }
            }
            Spacer(modifier = Modifier.size(24.dp))
            Text(
                text = "관심을 표한 회사에요",
                style = MaterialTheme.typography.nameMedium
            )
            Spacer(modifier = Modifier.size(12.dp))
            Card(
                elevation = CardDefaults.cardElevation(5.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colors.surface),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        0.5.dp,
                        MaterialTheme.colors.textFiledBackgroundVariant,
                        MaterialTheme.shapes.medium
                    )
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(Padding.large)
                ) {
                    WishItem(MaterialTheme.colors.background)
                    Spacer(modifier = Modifier.size(Padding.large))
                    WishItem(MaterialTheme.colors.secondary)
                    Spacer(modifier = Modifier.size(Padding.large))
                    WishItem(MaterialTheme.colors.background)
                }


            }
        }
    }
}



@Preview
@Composable
fun HomeScreenPreview(){
    WhaleTheme {
        HomeScreen()
    }
}