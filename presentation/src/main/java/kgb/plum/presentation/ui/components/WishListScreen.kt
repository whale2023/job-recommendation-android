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
import kgb.plum.presentation.ui.common.RecommendItem
import kgb.plum.presentation.ui.theme.Padding
import kgb.plum.presentation.ui.theme.WhaleTheme
import kgb.plum.presentation.ui.theme.colors

@Composable
fun WishListScreen() {
    Column(
        modifier = Modifier.background(MaterialTheme.colors.surface)
            .fillMaxSize()
            .padding(Padding.large)
    ){
        Text(
            text = "위시리스트",
            style = MaterialTheme.typography.headlineSmall
        )
    }
}


@Preview
@Composable
fun WishListScreenPreview() {
    WhaleTheme {
        WishListScreen()
    }
}