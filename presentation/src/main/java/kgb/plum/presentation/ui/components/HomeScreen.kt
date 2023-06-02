package kgb.plum.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kgb.plum.presentation.ui.theme.Padding
import kgb.plum.presentation.ui.theme.WhaleTheme
import kgb.plum.presentation.ui.theme.colors
import kgb.plum.presentation.ui.theme.nameMedium

@Composable
fun HomeScreen(){
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
            LazyRow(){

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
                modifier = Modifier.fillMaxWidth()
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

@Composable
fun WishItem(
    color: Color,
    company: String?= null,
    dDay: String?= null
){
    Row(
        modifier = Modifier
            .background(color, shape = MaterialTheme.shapes.large)
            .fillMaxWidth()
            .height(75.dp)
            .padding(horizontal = Padding.large),
        verticalAlignment = Alignment.CenterVertically
    ){
        if(company.isNullOrEmpty()){
            Text(
                text = "위시리스트를 추가해보세요.",
                style = MaterialTheme.typography.bodyMedium
            )
        } else {
            Text(
                text = company,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = dDay ?: "정보 없음",
                style = MaterialTheme.typography.bodyMedium
            )
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