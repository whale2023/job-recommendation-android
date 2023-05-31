package kumoh.whale.whale.recruit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kumoh.whale.whale.ui.theme.WhaleTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class RecruitActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      WhaleTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.background
        ) {
          RecruitView()
        }
      }
    }
  }
}

@Composable
fun RecruitView(
  viewModel: RecruitViewModel = viewModel()
) {
  Column(modifier = Modifier.padding(10.dp)) {
    RecruitHeader(viewModel.recruitList.size, viewModel.sortDropdownMenuController)
    Box(modifier = Modifier.height(24.dp))
    LazyColumn(
      verticalArrangement = Arrangement.spacedBy(10.dp),
      modifier = Modifier.fillMaxSize()
    ) {
      items(items = viewModel.recruitList) {
        RecruitListItem(recruitEntity = it, onWishChange = {})
      }
    }
  }
}

@Preview
@Composable
fun RecruitPreview() {
  Surface(
    modifier = Modifier.fillMaxSize(),
    color = MaterialTheme.colorScheme.background
  ) {
    RecruitView()
  }
}