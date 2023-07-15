package kgb.plum.presentation.ui.components.recruit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kgb.plum.domain.model.RecruitModel
import kgb.plum.presentation.R
import kgb.plum.presentation.ui.common.TagItem
import kgb.plum.presentation.ui.theme.Padding
import kgb.plum.presentation.ui.theme.Shapes
import kgb.plum.presentation.ui.theme.WhaleTheme
import kgb.plum.presentation.ui.theme.colors

@Composable
fun RecruitListItem(
  modifier: Modifier = Modifier,
  recruitModel: RecruitModel,
  onWishChange: () -> Unit,
) {
  var isWished by remember { mutableStateOf(recruitModel.isWished) }

  Card(
    shape = Shapes.large,
    elevation = CardDefaults.cardElevation(Padding.small),
    colors = CardDefaults.cardColors(MaterialTheme.colors.background),
    modifier = modifier.wrapContentSize(),
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(Padding.small),
      verticalAlignment = Alignment.Top,
      horizontalArrangement = Arrangement.spacedBy(Padding.medium),
    ) {
      Card(
        shape = Shapes.large,
        elevation = CardDefaults.cardElevation(),
        colors = CardDefaults.cardColors(MaterialTheme.colors.surface),
        modifier = Modifier
          .width(100.dp)
          .height(100.dp),
      ) {
        // TODO : Image 추가 필요
      }
      Column(
        modifier = Modifier
          .height(100.dp)
          .weight(1f),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start,
      ) {
        LazyRow(horizontalArrangement = Arrangement.spacedBy(Padding.medium)) {
          items(items = recruitModel.tag) {
            TagItem(tag = it, backgroundColor = MaterialTheme.colors.surface)
          }
        }
        Text(
          text = recruitModel.title,
          style = MaterialTheme.typography.displayMedium.copy(
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
          )
        )
        Text(
          text = recruitModel.company,
          style = MaterialTheme.typography.displaySmall.copy(
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.textSubColor
          )
        )
      }
      IconButton(
        onClick = {
          onWishChange()
          isWished = !isWished
        }, modifier = Modifier
          .size(30.dp)
          .padding(end = Padding.large)
      ) {
        Icon(
          painter = painterResource(id = R.drawable.clober),
          contentDescription = "찜하기",
          tint = if (!isWished) MaterialTheme.colors.surface else Color.Black
        )
//        Icon(if (isWished) Icons.Filled.Star else Icons.Outlined.Star, "Title Icon")
      }
    }
  }
}

@Preview
@Composable
fun PreviewWidget() {
  var isWished by remember { mutableStateOf(false) }
  WhaleTheme {
    Surface {
      RecruitListItem(
        recruitModel = RecruitModel(
          id = 1,
          title = "Title",
          company = "Company",
          tag = listOf("Tag", "Tag", "Tag"),
          isWished = isWished,
        ),
        onWishChange = {
          isWished = !isWished
        },
      )
    }
  }
}
