package kgb.plum.presentation.ui.components.myPage.edit

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Money
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kgb.plum.presentation.model.EducationType
import kgb.plum.presentation.model.MajorType
import kgb.plum.presentation.model.WorkType
import kgb.plum.presentation.ui.common.dropdown.CustomDropdownMenuController
import kgb.plum.presentation.ui.common.dropdown.CustomTextDropdownMenu
import kgb.plum.presentation.ui.common.textField.CustomTextField
import kgb.plum.presentation.ui.common.textField.CustomTextFieldController
import kgb.plum.presentation.ui.theme.Padding

@Composable
fun ResumeEditDialogBody(
  majorDropdownMenuController: CustomDropdownMenuController<MajorType>,
  educationDropdownMenuController: CustomDropdownMenuController<EducationType>,
  preferIncomeTextFieldController: CustomTextFieldController,
  workTypeDropdownMenuController: CustomDropdownMenuController<WorkType>
) {
  Row {
    CustomTextDropdownMenu(controller = educationDropdownMenuController, modifier = Modifier.weight(1f))
    Spacer(modifier = Modifier.padding(Padding.large))
    CustomTextDropdownMenu(controller = majorDropdownMenuController, modifier = Modifier.weight(3f))
  }
  Spacer(modifier = Modifier.padding(Padding.large))
  CustomTextDropdownMenu(controller = workTypeDropdownMenuController)
  Spacer(modifier = Modifier.padding(Padding.large))
  CustomTextField(customTextFieldController = preferIncomeTextFieldController, leadingIcon = Icons.Rounded.Money)
}