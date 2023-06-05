package kgb.plum.presentation.ui.common.textField

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import kgb.plum.presentation.ui.theme.colors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
  customTextFieldController: CustomTextFieldController,
  leadingIcon: ImageVector,
  modifier: Modifier = Modifier
) {
  println("CustomTexField : $customTextFieldController")
  BasicTextField(
    value = customTextFieldController.text,
    onValueChange = customTextFieldController::onTextChange,
    modifier = modifier
      .height(ButtonDefaults.MinHeight)
      .fillMaxWidth()
  ) {
    TextFieldDefaults.DecorationBox(
      value = customTextFieldController.text,
      innerTextField = it,
      enabled = false,
      singleLine = true,
      visualTransformation = VisualTransformation.None,
      interactionSource = remember { MutableInteractionSource() },
      leadingIcon = { Icon(leadingIcon, "Title Icon") },
      shape = ButtonDefaults.shape,
      colors = TextFieldDefaults.colors(
        focusedContainerColor = MaterialTheme.colors.background,
        unfocusedContainerColor = MaterialTheme.colors.background,
        disabledContainerColor = MaterialTheme.colors.background,
        disabledIndicatorColor = Color.Transparent, // 밑줄 삭제
      ),
      contentPadding = PaddingValues(0.dp, 0.dp, 10.dp, 0.dp), // 패딩 삭제
    )
  }
}