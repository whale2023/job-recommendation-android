package kgb.plum.presentation.ui.components.myPage.userInfo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kgb.plum.presentation.ui.theme.Padding
import kgb.plum.presentation.ui.theme.Shapes
import kgb.plum.presentation.ui.theme.Typography
import kgb.plum.presentation.ui.theme.WhaleTheme

@Composable
fun UserInfoHeader(
  name: String,
  description: String,
  modifier: Modifier = Modifier
) {
  Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
    Box(
      modifier = Modifier
        .size(100.dp)
        .clip(Shapes.extraLarge)
        .background(Color.White)
    )
    Spacer(modifier = Modifier.size(Padding.large))
    Text(text = name, style = Typography.displayMedium.copy(textAlign = TextAlign.Center))
    Spacer(modifier = Modifier.size(Padding.medium))
    Text(text = description, style = Typography.displaySmall.copy(textAlign = TextAlign.Center))
  }
}

@Preview
@Composable
fun UserInfoHeaderPreview() {
  WhaleTheme {
    UserInfoHeader(
      "박준식",
      "구미에 거주하며 사무업 취직을 희망하고\n 편식을 어려워 합니다."
    )
  }
}
