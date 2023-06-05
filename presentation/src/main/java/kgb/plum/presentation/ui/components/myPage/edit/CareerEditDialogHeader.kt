package kgb.plum.presentation.ui.components.myPage.edit

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kgb.plum.presentation.ui.common.textField.CustomTextField
import kgb.plum.presentation.ui.common.textField.CustomTextFieldController
import kgb.plum.presentation.ui.theme.Padding

@Composable
fun CareerEditDialogHeader(textFieldController: CustomTextFieldController) {
  Row {
    CustomTextField(
      customTextFieldController = textFieldController,
      leadingIcon = Icons.Rounded.Search
    )
    Spacer(modifier = Modifier.width(Padding.large))
  }
}