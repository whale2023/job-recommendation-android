package kgb.plum.presentation.ui.components.myPage.edit

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Dashboard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kgb.plum.domain.model.CareerModel
import kgb.plum.presentation.model.CareerType
import kgb.plum.presentation.ui.theme.Padding
import kgb.plum.presentation.ui.theme.Typography

@Composable
fun CareerEditDialogBody(
  careerList: List<CareerType>,
  onAddButtonClicked: (CareerModel) -> Unit
) {
  LazyColumn {
    items(items = careerList) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
          Icons.Rounded.Dashboard, "Edit Icon",
          modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(Padding.medium))
        Text(
          text = it.toString(), style = Typography.displaySmall.copy(
            fontWeight = FontWeight.Bold
          )
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { onAddButtonClicked(CareerModel(3, it.toString())) }) {
          Icon(Icons.Rounded.Add, "추가 버튼")
        }
      }
    }
  }
}