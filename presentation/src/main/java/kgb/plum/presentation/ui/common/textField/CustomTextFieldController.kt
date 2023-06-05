package kgb.plum.presentation.ui.common.textField

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class CustomTextFieldController(private val onTextChangeCallback: () -> Unit = {}) {
  var text by mutableStateOf("")
  fun onTextChange(value: String, callback: () -> Unit = onTextChangeCallback) {
    text = value
    println("CustomTexField : $text, $value")
    callback()
  }

  fun clearText() {
    text = ""
  }
}