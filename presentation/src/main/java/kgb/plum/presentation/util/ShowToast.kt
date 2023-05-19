package kgb.plum.presentation.util

import android.content.Context
import android.widget.Toast


fun ShowToast(context: Context, message: String) {
    val toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
    toast.show()
}