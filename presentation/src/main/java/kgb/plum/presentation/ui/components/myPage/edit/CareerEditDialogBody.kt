package kgb.plum.presentation.ui.components.myPage.edit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import kgb.plum.domain.model.CareerModel
import kgb.plum.presentation.model.CareerMajorType
import kgb.plum.presentation.ui.common.dropdown.CustomDropdownMenuController
import kgb.plum.presentation.ui.common.dropdown.CustomTextDropdownMenu
import kgb.plum.presentation.ui.common.dropdown.CustomTitledTextDropdownMenu
import kgb.plum.presentation.ui.theme.Padding
import kgb.plum.presentation.ui.theme.colors

@Composable
fun CareerEditDialogBody(
  majorCategoryDropdownMenuController: CustomDropdownMenuController<CareerMajorType>,
  yearDropdownMenuController: CustomDropdownMenuController<Int>,
  onAddButtonClicked: (CareerModel) -> Unit
) {
  val middleCategoryDropdownMenuController = CustomDropdownMenuController(
    majorCategoryDropdownMenuController.currentValue.getMiddleType()[0],
    majorCategoryDropdownMenuController.currentValue.getMiddleType(),
  )
  Column() {
    Spacer(modifier = Modifier.height(Padding.large))
    CustomTitledTextDropdownMenu(
      controller = majorCategoryDropdownMenuController,
      offset = DpOffset((-70).dp, 10.dp),
      title = "대분류",
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(Padding.large))
    CustomTitledTextDropdownMenu(
      controller = middleCategoryDropdownMenuController,
      offset = DpOffset((-70).dp, 10.dp),
      title = "중분류",
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(Padding.large))
    Row(
      verticalAlignment = Alignment.Bottom,
      horizontalArrangement = Arrangement.SpaceBetween,
      modifier = Modifier.fillMaxWidth()
    ) {
      Box(modifier = Modifier.weight(1f)) {
        CustomTitledTextDropdownMenu(
          controller = yearDropdownMenuController,
          offset = DpOffset((-70).dp, 10.dp),
          title = "연차",
          modifier = Modifier.fillMaxWidth()
        )
      }
      Spacer(modifier = Modifier.width(Padding.large))
      Button(
        onClick = {
          onAddButtonClicked(
            CareerModel(
              yearDropdownMenuController.currentValue,
              if (middleCategoryDropdownMenuController.currentValue.toString() == "해당 없음") "${majorCategoryDropdownMenuController.currentValue}/" else "${majorCategoryDropdownMenuController.currentValue}/${middleCategoryDropdownMenuController.currentValue}"
            )
          )
        },
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colors.tertiary),
        modifier = Modifier.padding(0.dp)
      ) {
        Text(text = "추가")
      }
    }
  }
}