package kgb.plum.presentation.ui.components.myPage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kgb.plum.presentation.ui.theme.Shapes

@Composable
fun UserInfoItem() {
  Column(horizontalAlignment = Alignment.CenterHorizontally) {
    Box(modifier = Modifier
      .size(50.dp)
      .clip(Shapes.extraLarge)
      .background(Color.White))
  }
}

@Preview
@Composable
fun UserInfoItemPreview() {
  UserInfoItem()
}
