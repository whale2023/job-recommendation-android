package kgb.plum.presentation.ui.common


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dagger.hilt.android.lifecycle.HiltViewModel
import kgb.plum.domain.usecase.WishUseCase
import kgb.plum.presentation.R
import kgb.plum.presentation.ui.theme.Padding
import kgb.plum.presentation.ui.theme.WhaleTheme
import kgb.plum.presentation.ui.theme.colors
import kgb.plum.presentation.viewmodel.RecommendViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

@Composable
fun RecommendItem(
    color : Color,
    id : Int,
    company: String,
    occupation: String,
    recommendReason: List<String>,
    score: Double,
    isWished: Boolean = false,
    viewModel: RecommendViewModel
) {
    Card(
        colors = CardDefaults.cardColors(color),
        elevation = CardDefaults.cardElevation(5.dp),
        modifier = Modifier
            .width(320.dp)
            .height(340.dp)
    ){
        Column(
            modifier = Modifier
                .padding(Padding.medium)
                .fillMaxSize()
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Column(){
                    Text(
                       text = company,
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Text(
                        text = occupation,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    onClick = {viewModel.changeWishStatus(isWished, id)}
                ){
                    Icon(
                        painter = if(isWished) painterResource(id = R.drawable.clober) else painterResource(id = R.drawable.selected_clover),
                        contentDescription = "찜하기",
                        tint = MaterialTheme.colors.surface
                    )
                }
            }
            Spacer(modifier = Modifier.size(24.dp))
            Box(
                modifier = Modifier
                    .background(
                        MaterialTheme.colors.surface,
                        shape = RoundedCornerShape(topStartPercent = 6, topEndPercent = 6)
                    )
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding(Padding.medium)
            ) {
                Column() {
                    recommendReason.forEach { item ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.thumb_up),
                                contentDescription = "추천",
                                tint = MaterialTheme.colors.primary,
                                modifier = Modifier.size(18.dp),
                            )
                            }
                            Spacer(modifier = Modifier.size(6.dp))
                            Text(
                                text = item,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
            Spacer(modifier =  Modifier.size(6.dp))
            Box(
                modifier = Modifier
                    .background(
                        MaterialTheme.colors.surface,
                        shape = RoundedCornerShape(bottomStartPercent = 12, bottomEndPercent = 12)
                    )
                    .height(40.dp)
                    .fillMaxWidth()
                    .padding(Padding.medium)
            ) {
                Text(
                    text = "추천 점수 : ${score}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }   
    }
}

@Preview
@Composable
fun RecommendItemPreview() {
    WhaleTheme{
        RecommendItem(MaterialTheme.colors.background, "금오컴피니", "영업직", listOf("10년 이상 무사고", "집이랑 가까우요", "연봉이 높아요", "주변에 건강센터가 있어요"), 82.6)
    }
}
