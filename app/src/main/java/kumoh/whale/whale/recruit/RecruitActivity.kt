package kumoh.whale.whale.recruit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
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
import kumoh.whale.whale.ui.commons.RecruitListItem

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
  LazyColumn(
    verticalArrangement = Arrangement.spacedBy(10.dp)
  ) {
    items(items = viewModel.recruitList) {
      RecruitListItem(recruitEntity = it, onWishChange = {})
    }
  }
}

@Preview
@Composable
fun RecruitPreview() {
  RecruitView()
}