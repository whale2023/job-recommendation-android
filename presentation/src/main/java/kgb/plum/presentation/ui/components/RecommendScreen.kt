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
import androidx.hilt.navigation.compose.hiltViewModel
import kgb.plum.domain.model.RecommendItemData
import kgb.plum.presentation.ui.common.RecommendItem
import kgb.plum.presentation.ui.theme.Padding
import kgb.plum.presentation.ui.theme.WhaleTheme
import kgb.plum.presentation.ui.theme.colors
import kgb.plum.presentation.viewmodel.RecommendViewModel

@Composable
fun RecommendScreen() {
    val viewModel = hiltViewModel<RecommendViewModel>()
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.surface)
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
            items(viewModel.recommendList) { item ->
                RecommendItem(
                    id = item.id,
                    color = if(item.id%2==1) MaterialTheme.colors.background else MaterialTheme.colors.secondary,
                    company = item.company,
                    occupation = item.occupation,
                    recommendReason = item.recommendReason,
                    score = item.score,
                    isWished = item.isWish,
                    viewModel = viewModel
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