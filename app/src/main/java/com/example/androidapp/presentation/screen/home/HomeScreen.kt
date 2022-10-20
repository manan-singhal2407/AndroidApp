@file:Suppress("MagicNumber")

package com.example.androidapp.presentation.screen.home

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidapp.R
import com.example.androidapp.presentation.theme.BackgroundColor
import com.example.androidapp.presentation.theme.Primary10
import com.example.androidapp.presentation.theme.QuickSand
import com.example.androidapp.presentation.theme.atom.Image
import com.example.androidapp.presentation.theme.atom.PrimaryButton
import com.example.androidapp.presentation.theme.atom.TextInput
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current
    val bringIntoViewRequester = BringIntoViewRequester()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.width(12.dp))
            Image(
                modifier = Modifier
                    .width(120.dp)
                    .height(52.dp)
                    .clip(RoundedCornerShape(12.dp)),
                url = stringResource(id = R.string.image2),
                contentScale = ContentScale.FillBounds
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        val state = rememberPagerState()
        val image = stringResource(id = R.string.image1)
        val slideImage = remember { mutableStateOf(image) }
        HorizontalPager(count = 2, state = state) { page ->
            when (page) {
                0 -> {
                    slideImage.value = stringResource(id = R.string.image1)
                }
                1 -> {
                    slideImage.value = stringResource(id = R.string.image2)
                }
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(horizontal = 20.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    url = slideImage.value,
                    contentScale = ContentScale.FillBounds
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
        DotsIndicator(
            totalDots = 2,
            selectedIndex = state.currentPage
        )
        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier
                .fillMaxSize()
                .heightIn(min = LocalConfiguration.current.screenHeightDp.dp - 304.dp)
                .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp)),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Register",
                color = Primary10,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = QuickSand,
                modifier = Modifier.padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Divider(
                color = Primary10,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(1.dp)
                    .padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Date of Birth",
                color = Primary10,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = QuickSand,
                modifier = Modifier.padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            DOBView(context, viewModel)
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Gender",
                color = Primary10,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = QuickSand,
                modifier = Modifier.padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            GenderRadioButtonOption(viewModel)
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Email",
                color = Primary10,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = QuickSand,
                modifier = Modifier.padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            TextInput(
                hint = "example@gmail.com",
                onTextChange = { viewModel.email.value = it },
                modifier = Modifier
                    .padding(start = 24.dp, end = 72.dp)
                    .onFocusChanged { event ->
                        if (event.isFocused) {
                            coroutineScope.launch {
                                bringIntoViewRequester.bringIntoView()
                            }
                        }
                    },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { focusManager.clearFocus() }
                ),
            )
            Spacer(modifier = Modifier.height(24.dp))
            PrimaryButton(
                label = "Continue(2/2)",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                    .bringIntoViewRequester(bringIntoViewRequester),
                onClick = { viewModel.saveUserData(context = context) },
                enabled = !viewModel.savingData.value
            )
        }
    }
}

@Composable
fun DotsIndicator(totalDots: Int, selectedIndex: Int) {
    LazyRow(
        modifier = Modifier.wrapContentSize()
    ) {
        items(totalDots) { index ->
            if (index == selectedIndex) {
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                )
            }

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}

@Composable
fun DOBView(context: Context, viewModel: HomeViewModel) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            modifier = Modifier
                .wrapContentSize()
                .padding(start = 24.dp),
            shape = RoundedCornerShape(12.dp),
            shadowElevation = 12.dp
        ) {
            Text(
                text = viewModel.date.value.ifEmpty { "__/__/____" },
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight.W600,
                fontFamily = QuickSand,
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp)
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        IconButton(
            onClick = { viewModel.showDateDialog(context = context) }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_calendar),
                contentDescription = "",
                modifier = Modifier.size(22.dp)
            )
        }
    }
}

@Composable
fun GenderRadioButtonOption(viewModel: HomeViewModel) {
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(viewModel.genderOptions[0]) }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        viewModel.genderOptions.forEach { text ->
            Row(
                Modifier
                    .wrapContentWidth()
                    .heightIn(max = 40.dp)
                    .padding(horizontal = 4.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = {
                        onOptionSelected(text)
                        viewModel.selectedOption.value = text
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Black
                    )
                )
                Text(
                    text = text,
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.W600,
                    fontFamily = QuickSand,
                    modifier = Modifier
                        .wrapContentWidth()
                        .fillMaxHeight()
                        .padding(top = 8.dp, end = 12.dp)
                )
            }
        }
    }
}