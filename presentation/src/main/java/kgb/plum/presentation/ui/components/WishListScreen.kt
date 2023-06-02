package kgb.plum.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kgb.plum.presentation.R
import kgb.plum.presentation.ui.common.WishItem
import kgb.plum.presentation.ui.theme.Padding
import kgb.plum.presentation.ui.theme.WhaleTheme
import kgb.plum.presentation.ui.theme.colors
import kgb.plum.presentation.viewmodel.WishListViewModel

@Composable
fun WishListScreen() {
    val viewModel = hiltViewModel<WishListViewModel>()
    val isCalendar = remember { mutableStateOf(false)}
    if(isCalendar.value){
        Text("하이")
    } else {
        WishListForListScreen(isCalendar, viewModel)
    }
}

@Composable
fun WishListForListScreen(
    isCalendar : MutableState<Boolean>,
    viewModel : WishListViewModel
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.surface)
            .fillMaxSize()
            .padding(Padding.large)
    ){
        Text(
            text = "위시리스트",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.size(Padding.large))
        LazyColumn(
            contentPadding = PaddingValues(vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(viewModel.wishList) { index, item ->
                WishItem(color = if(index%2==0) MaterialTheme.colors.background else MaterialTheme.colors.secondary, company = item.company, occupation = item.occupation, dDay = item.dDay)
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Row {
            Spacer(modifier = Modifier.weight(1f))
            FloatingActionButton(
                onClick = { isCalendar.value = true },
                shape = CircleShape,
                containerColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.surface,
                elevation = FloatingActionButtonDefaults.elevation(10.dp),
                modifier = Modifier
                    .size(70.dp),
            ) {
                Image(painter = painterResource(id = R.drawable.calendar), contentDescription = "달력", modifier = Modifier.fillMaxSize(0.7f))
            }
        }
    }
}

@Composable
fun WishListForCalendar(
    //isCalendar: MutableState<Boolean>,
    //viewModel: WishListViewModel
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.surface)
            .fillMaxSize()
            .padding(Padding.large)
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Row {
            Spacer(modifier = Modifier.weight(1f))
            FloatingActionButton(
                onClick = { TODO("전환") },
                shape = CircleShape,
                containerColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.surface,
                elevation = FloatingActionButtonDefaults.elevation(10.dp),
                modifier = Modifier
                    .size(70.dp),
            ) {
                Image(painter = painterResource(id = R.drawable.list), contentDescription = "리스트", modifier = Modifier.fillMaxSize(0.7f))
            }
        }
    }
}

@Preview
@Composable
fun WishListForCalendarPreview() {
    WhaleTheme {
        WishListForCalendar()
    }
}



@Preview
@Composable
fun ButtonPreview() {
    WhaleTheme {
        FloatingActionButton(
            onClick = { /*TODO*/ },
            shape = CircleShape,
            containerColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.surface,
            elevation = FloatingActionButtonDefaults.elevation(10.dp),
            modifier = Modifier
                .size(70.dp),
        ) {
            Image(painter = painterResource(id = R.drawable.calendar), contentDescription = "달력",modifier = Modifier.fillMaxSize(0.5f))
        }
    }
}