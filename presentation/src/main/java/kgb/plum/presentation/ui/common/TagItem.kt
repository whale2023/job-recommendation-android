package kgb.plum.presentation.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TagItem(
  modifier: Modifier = Modifier,
  backgroundColor: Color,
  tag: String,
) {
  Box(
    modifier = modifier
      .wrapContentSize()
      .clip(RoundedCornerShape(50.dp))
      .background(color = backgroundColor),
  ) {
    Text(
      text = tag,
      color = Color(0xFF9E9E9E),
      textAlign = TextAlign.Center,
      fontWeight = FontWeight.Bold,
      modifier = Modifier.padding(horizontal = 10.dp, vertical = 1.dp),
    )
  }
}