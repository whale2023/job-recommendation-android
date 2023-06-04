package kgb.plum.presentation.ui.components.recruit

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExpandLess
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import kgb.plum.presentation.ui.common.CustomTextField
import kgb.plum.presentation.ui.common.TagItem
import kgb.plum.presentation.ui.theme.Padding
import kgb.plum.presentation.ui.theme.colors
import kgb.plum.presentation.viewmodel.FilterScreenViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FilterScreen(navController: NavHostController) {
  val viewModel = hiltViewModel<FilterScreenViewModel>()
  viewModel.init(navController)
  Surface(modifier = Modifier.background(Color.Transparent)) {
    Column(
      verticalArrangement = Arrangement.Center,
      modifier = Modifier.padding(Padding.large, Padding.large, Padding.large, 0.dp)
    ) {
      CustomTextField(
        customTextFieldController = viewModel.searchTextFieldController,
        Icons.Rounded.Search
      )
      Spacer(modifier = Modifier.height(Padding.xlarge))
      FlowRow(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        viewModel.filterList.forEach { it ->
          TagItem(
            backgroundColor = MaterialTheme.colors.background,
            tag = it.toString(),
            modifier = Modifier.padding(Padding.small),
            onClick = { Log.d("FilterScreen", "$it clicked") }
          )
        }
      }
      Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        IconButton(onClick = viewModel::navigatePop) {
          Icon(
            Icons.Rounded.ExpandLess,
            "Back Btn",
          )
        }
      }
    }
  }
}