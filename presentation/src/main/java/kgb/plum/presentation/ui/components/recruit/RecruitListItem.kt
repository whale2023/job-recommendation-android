package kgb.plum.presentation.ui.components.recruit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Cake
import androidx.compose.material.icons.rounded.Cake
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kgb.plum.domain.model.RecruitModel
import kgb.plum.presentation.ui.common.TagItem

@Composable
fun RecruitListItem(
  modifier: Modifier = Modifier,
  recruitModel: RecruitModel,
  onWishChange: () -> Unit,
) {
  Card(
    shape = RoundedCornerShape(10.dp),
    elevation = CardDefaults.cardElevation(5.dp),
    colors = CardDefaults.cardColors(Color.White),
    modifier = modifier.wrapContentSize(),
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp),
      verticalAlignment = Alignment.Top,
      horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
      Card(
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(),
        colors = CardDefaults.cardColors(Color(0xFFD0E7FF)),
        modifier = Modifier
          .width(100.dp)
          .height(100.dp),
      ) {

      }
      Column(
        modifier = Modifier
          .height(100.dp)
          .weight(1f),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start,
      ) {
        LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
          items(items = recruitModel.tag) {
            TagItem(tag = it, backgroundColor = Color(0xFFF9F9F9))
          }
        }
        Text(
          text = recruitModel.title,
          fontSize = 18.sp,
          textAlign = TextAlign.Center,
          fontWeight = FontWeight.Bold
        )
        Text(
          text = recruitModel.company,
          color = Color(0xFF9E9E9E),
          textAlign = TextAlign.Center,
        )
      }
      IconButton(
        onClick = onWishChange, modifier = Modifier
          .size(30.dp)
          .padding(end = 10.dp)
      ) {
        Icon(if (recruitModel.isWished) Icons.Rounded.Cake else Icons.Outlined.Cake, "Title Icon")
      }
    }
  }
}

@Preview
@Composable
fun PreviewWidget() {
  var isWished by remember { mutableStateOf(false) }
  Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
    RecruitListItem(
      recruitModel = RecruitModel(
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
