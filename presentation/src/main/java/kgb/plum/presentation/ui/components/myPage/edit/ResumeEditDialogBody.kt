package kgb.plum.presentation.ui.components.myPage.edit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Money
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kgb.plum.domain.model.CareerModel
import kgb.plum.domain.model.ResumeModel
import kgb.plum.presentation.model.EducationType
import kgb.plum.presentation.model.MajorType
import kgb.plum.presentation.model.WorkType
import kgb.plum.presentation.ui.common.dropdown.CustomDropdownMenuController
import kgb.plum.presentation.ui.common.dropdown.CustomTextDropdownMenu
import kgb.plum.presentation.ui.common.dropdown.CustomTitledTextDropdownMenu
import kgb.plum.presentation.ui.common.textField.CustomTextField
import kgb.plum.presentation.ui.common.textField.CustomTextFieldController
import kgb.plum.presentation.ui.theme.Padding
import kgb.plum.presentation.ui.theme.colors

@Composable
fun ResumeEditDialogBody(
  majorDropdownMenuController: CustomDropdownMenuController<MajorType>,
  educationDropdownMenuController: CustomDropdownMenuController<EducationType>,
  preferIncomeTextFieldController: CustomTextFieldController,
  workTypeDropdownMenuController: CustomDropdownMenuController<WorkType>,
  onEditButtonClicked: () -> Unit
) {
  Column {
    Spacer(modifier = Modifier.padding(Padding.large))
    Row(
      verticalAlignment = Alignment.Bottom,
      horizontalArrangement = Arrangement.SpaceBetween,
      modifier = Modifier.fillMaxWidth()
    ) {
      Box(modifier = Modifier.weight(1f)) {
        CustomTitledTextDropdownMenu(
          controller = educationDropdownMenuController,
          title = "학력",
          modifier = Modifier.fillMaxWidth()
        )
      }
      Spacer(modifier = Modifier.padding(Padding.large))
      Box(modifier = Modifier.weight(2f)) {
        CustomTitledTextDropdownMenu(
          controller = majorDropdownMenuController,
          title = "전공",
          modifier = Modifier.fillMaxWidth()
        )
      }
    }
    Spacer(modifier = Modifier.padding(Padding.large))
    CustomTitledTextDropdownMenu(
      controller = workTypeDropdownMenuController,
      title = "선호 개약 방식",
      modifier = Modifier.fillMaxWidth()
    )
    Row(
      verticalAlignment = Alignment.Bottom,
      horizontalArrangement = Arrangement.SpaceBetween,
      modifier = Modifier.fillMaxWidth()
    ) {
      Box(modifier = Modifier.weight(1f)) {
        CustomTextField(
          customTextFieldController = preferIncomeTextFieldController,
          leadingIcon = Icons.Rounded.Money
        )
      }
      Spacer(modifier = Modifier.padding(Padding.large))
      Button(
        onClick = onEditButtonClicked,
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colors.tertiary),
        modifier = Modifier.padding(0.dp)
      ) {
        Text(text = "수정")
      }
    }
  }
}