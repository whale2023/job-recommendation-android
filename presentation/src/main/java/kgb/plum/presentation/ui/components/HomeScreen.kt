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
import androidx.hilt.navigation.compose.hiltViewModel
import kgb.plum.domain.model.RecruitRankItem
import kgb.plum.presentation.ui.common.RecruitCardItem
import kgb.plum.presentation.ui.common.WishItem
import kgb.plum.presentation.ui.theme.Padding
import kgb.plum.presentation.ui.theme.WhaleTheme
import kgb.plum.presentation.ui.theme.colors
import kgb.plum.presentation.ui.theme.nameMedium
import kgb.plum.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(){
    val viewModel = hiltViewModel<HomeViewModel>()
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
                items(viewModel.popularCompany, key = {it.rank}) { item ->
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
                    WishItem(MaterialTheme.colors.background,
                        viewModel.wishList[0].company,
                        viewModel.wishList[0].occupation,
                        viewModel.wishList[0].dDay)
                    Spacer(modifier = Modifier.size(Padding.large))
                    WishItem(MaterialTheme.colors.secondary,
                        viewModel.wishList[1].company,
                        viewModel.wishList[1].occupation,
                        viewModel.wishList[1].dDay)
                    Spacer(modifier = Modifier.size(Padding.large))
                    WishItem(MaterialTheme.colors.background,
                        viewModel.wishList[2].company,
                        viewModel.wishList[2].occupation,
                        viewModel.wishList[2].dDay)
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