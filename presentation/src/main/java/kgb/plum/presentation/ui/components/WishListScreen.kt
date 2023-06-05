package kgb.plum.presentation.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.himanshoe.kalendar.Kalendar
import com.himanshoe.kalendar.KalendarEvents
import com.himanshoe.kalendar.KalendarType
import com.himanshoe.kalendar.color.KalendarColor
import com.himanshoe.kalendar.color.KalendarColors
import com.himanshoe.kalendar.ui.component.header.KalendarTextKonfig
import com.himanshoe.kalendar.ui.firey.DaySelectionMode
import kgb.plum.presentation.R
import kgb.plum.presentation.ui.common.WishItem
import kgb.plum.presentation.ui.theme.Padding
import kgb.plum.presentation.ui.theme.WhaleTheme
import kgb.plum.presentation.ui.theme.colors
import kgb.plum.presentation.viewmodel.WishListViewModel
import kotlinx.datetime.LocalDate


@Composable
fun WishListScreen() {
    val viewModel = hiltViewModel<WishListViewModel>()
    val isCalendar = remember { mutableStateOf(false)}
    if(isCalendar.value){
        WishListForCalendar(isCalendar, viewModel)
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WishListForCalendar(
    isCalendar: MutableState<Boolean>,
    viewModel: WishListViewModel
) {
    val list = mutableListOf<KalendarColor>()
    for(i in 1..12){
        list.add(
            KalendarColor(
            backgroundColor = MaterialTheme.colors.surface,
            dayBackgroundColor = MaterialTheme.colors.surface,
            headerTextColor = MaterialTheme.colors.primary
        )
        )
    }
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.surface)
            .fillMaxSize()
            .padding(Padding.large)
    ) {
        Kalendar(
            currentDay = null,
            kalendarType = KalendarType.Firey,
            modifier = Modifier.wrapContentHeight(),
            showLabel = true,
            events = KalendarEvents(viewModel.eventList),
            kalendarHeaderTextKonfig = KalendarTextKonfig(MaterialTheme.colors.primary, 32.sp),
            kalendarColors = KalendarColors(list),
            daySelectionMode = DaySelectionMode.Single,
            dayContent = { date ->
                Column(
                    modifier = Modifier.height(70.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.size(12.dp))
                    Text(
                        text = date.dayOfMonth.toString(),
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                        modifier = if(date.compareTo(LocalDate(java.time.LocalDate.now().year,java.time.LocalDate.now().month, java.time.LocalDate.now().dayOfMonth))==0 ) Modifier.size(36.dp).background( MaterialTheme.colors.background , shape = CircleShape) else Modifier
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    viewModel.wishList.forEach { item ->
                        if(item.deadLine == date.toString()){
                            Text(
                                text = item.company,
                                modifier = Modifier.background(MaterialTheme.colors.secondary),
                                style = MaterialTheme.typography.labelSmall
                            )
                            Spacer(modifier = Modifier.size(6.dp))
                        }
                    }
                }

            },
            headerContent = null,
            onDayClick = { selectedDay, events ->
                // Handle day click event
            },
            onRangeSelected = { selectedRange, events ->
                // Handle range selection event
            },
            onErrorRangeSelected = { error ->
                // Handle error
            }
        )
        Spacer(modifier = Modifier.weight(1f))
        Row {
            Spacer(modifier = Modifier.weight(1f))
            FloatingActionButton(
                onClick = { isCalendar.value = false },
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