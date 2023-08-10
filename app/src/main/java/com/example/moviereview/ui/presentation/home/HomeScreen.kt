package com.example.moviereview.ui.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.moviereview.ui.conditional
import com.example.moviereview.ui.presentation.home.tabs.HomeTabScreen
import com.example.moviereview.ui.presentation.home.tabs.homeTabScreens
import com.example.moviereview.ui.presentation.navigation.NavigationBarScreen
import com.example.moviereview.ui.theme.*

fun NavGraphBuilder.homeScreen() {
    composable(NavigationBarScreen.HomeScreen.route) {
        HomeScreen()
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    var currentTab by remember {
        mutableStateOf(homeTabScreens[0])
    }

    Scaffold(
        topBar = {
            HomeTabBar(
                tabSelected = currentTab,
                onTabSelected = { tab ->
                    currentTab = tab
                },
            )
        }
    ) { padding ->
        Box(Modifier.padding(padding)) {
            currentTab.screen()
        }
    }
}

@Composable
fun HomeTabBar(
    tabSelected: HomeTabScreen,
    onTabSelected: (HomeTabScreen) -> Unit,
) {
    TabRow(
        modifier = Modifier
            .padding(
                start = tabLayoutMargin,
                top = tabLayoutMargin,
                end = tabLayoutMargin,
            )
            .clip(RoundedCornerShape(tabLayoutRadius)),
        containerColor = tabLayoutColor,
        selectedTabIndex = homeTabScreens.indexOf(tabSelected),
        indicator = { },
    ) {
        homeTabScreens.forEach { tab ->
            TabItem(
                tabSelected = tab,
                isTabSelected = tab == tabSelected,
                onTabSelected = { onTabSelected(tab) },
            )
        }
    }
}

@Composable
fun TabItem(
    tabSelected: HomeTabScreen,
    isTabSelected: Boolean,
    onTabSelected: () -> Unit,
) {
    Tab(
        modifier = Modifier
            .clip(RoundedCornerShape(tabLayoutRadius))
            .conditional(isTabSelected) {
                background(color = tabSelectedColor)
            },
        selected = isTabSelected,
        onClick = onTabSelected,
    ) {
        val textColor = if (isTabSelected) {
            tabSelectedTextColor
        } else {
            tabLayoutTextColor
        }
        Text(
            modifier = Modifier.padding(vertical = tabLayoutPadding),
            text = tabSelected.title,
            color = textColor,
            style = TextStyle(
                fontFamily = Gilroy,
                fontSize = tabLayoutFontSize,
            ),
        )
    }
}

@Preview
@Composable
fun HomeTabBarPreview() {
    HomeTabBar(
        tabSelected = homeTabScreens[0],
        onTabSelected = {},
    )
}
