package com.example.moviereview.ui.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
import org.koin.java.KoinJavaComponent.inject

fun NavGraphBuilder.homeScreen() {
    composable(NavigationBarScreen.HomeScreen.route) {
        HomeScreen()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel by inject(HomeViewModel::class.java)
    var currentTab by remember {
        mutableStateOf(homeTabScreens[0])
    }
    val isRefreshing = viewModel.isRefreshing
    val refreshState = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = {
            when (currentTab) {
                HomeTabScreen.Movie -> viewModel.reloadMovies()
                HomeTabScreen.TvShow -> viewModel.reloadTvShows()
            }
        }
    )

    Scaffold(
        topBar = {
            HomeTabBar(
                tabSelected = currentTab,
                onTabSelected = { tab ->
                    currentTab = tab
                },
            )
        }
    ) {
        Box(
            modifier = Modifier.pullRefresh(state = refreshState)
        ) {
            val movieListState = when (currentTab) {
                HomeTabScreen.Movie -> viewModel.movieListState
                HomeTabScreen.TvShow -> viewModel.tvShowsListState
            }
            currentTab.screen(movieListState)

            PullRefreshIndicator(
                modifier = Modifier.align(Alignment.TopCenter),
                refreshing = isRefreshing,
                state = refreshState
            )
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
                start = tabLayoutPaddingLarge,
                top = tabLayoutPaddingLarge,
                end = tabLayoutPaddingLarge,
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
            modifier = Modifier.padding(vertical = tabLayoutPaddingSmall),
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
