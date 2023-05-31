package com.example.jetpackprofilepractice

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackexample.ui.theme.JetpackExampleTheme
import com.example.navigationdrawercomposeexample.R
import com.google.accompanist.pager.ExperimentalPagerApi

class HomeActivity(navController: NavController) : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val mainViewModel by viewModels<MainViewModel>()

//        mainViewModel.getAllMovies()

        setContent {

            JetpackExampleTheme() {

                TopAppBar(
                    title = { Text("My Application") },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = colorResource(
                            id = R.color.dark_grey
                        )
                    )

                )
                Box(modifier = Modifier.fillMaxSize()) {

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = colorResource(id = R.color.bg_color)),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

//                        MyHomePage()
//                        val mainViewModel by viewModels<MainViewModel>()
//                        mainViewModel.getAllMovies()
//
//                        val state = rememberPagerState()
//                        Column {
//
//                            Log.d("cmgggg", "cmggg")
//
//                            SliderView(state, mainViewModel)
//
//                            Spacer(modifier = Modifier.padding(5.dp))
//
//                            DotsIndicator(
//                                totalDots = mainViewModel.movieListResponse.size,
//                                selectedIndex = state.currentPage
//                            )
//
////                        LazyColumn() {
////                            items(mainViewModel.movieListResponse) {
////
////                                    item ->
////                                MovieCard(moviesDataItem = item)
////                            }
////
////                        }
//                        }
//
//                        LaunchedEffect(key1 = state.currentPage) {
//                            delay(3000)
//                            var newPosition = state.currentPage + 1
//                            if (newPosition > mainViewModel.movieListResponse.size - 1) newPosition =
//                                0
//                            state.animateScrollToPage(newPosition)
//                        }
                    }
                }

            }
        }

    }

//    @OptIn(ExperimentalPagerApi::class)
//    @Composable
//    fun SliderView(state: PagerState, viewModel: MainViewModel) {
//
//        val imageUrl = remember { mutableStateOf("") }
//        HorizontalPager(
//            state = state,
//            count = viewModel.movieListResponse.size,
//            modifier = Modifier
//                .height(200.dp)
//                .fillMaxWidth()
//        ) { page ->
//            imageUrl.value = viewModel.movieListResponse[page].imageUrl
//
//            Column(
//                modifier = Modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Top,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Box(contentAlignment = Alignment.BottomCenter) {
//
//                    val painter = rememberImagePainter(data = imageUrl.value, builder = {
//                        placeholder(R.drawable.ic_launcher_background)
//                    })
//                    Image(
//                        painter = painter,
//                        contentDescription = "",
//                        Modifier
//                            .padding(8.dp)
//                            .clip(RoundedCornerShape(10.dp))
//                            .fillMaxSize(),
//                        contentScale = ContentScale.Crop
//                    )
//
//                    Text(
//                        text = viewModel.movieListResponse[page].name,
//                        Modifier
//                            .fillMaxWidth()
//                            .height(60.dp)
//                            .padding(8.dp)
//                            .background(Color.LightGray.copy(alpha = 0.60F))
//                            .padding(8.dp),
//                        textAlign = TextAlign.Start,
//                        fontSize = 18.sp,
//                        fontWeight = FontWeight.Medium
//                    )
//                }
//
//
//            }
//
//
//        }
//    }
//
//    @Composable
//    fun MovieCard(moviesDataItem: MoviesDataItem) {
//
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(100.dp)
//        ) {
//
//            Text(text = moviesDataItem.name, Modifier.fillMaxWidth())
//
//        }
//    }
//
//    @Composable
//    fun DotsIndicator(
//        totalDots: Int, selectedIndex: Int
//    ) {
//
//        LazyRow(
//            modifier = Modifier
//                .fillMaxWidth()
//                .wrapContentHeight(),
//            horizontalArrangement = Arrangement.Center
//        ) {
//
//            items(totalDots) { index ->
//                if (index == selectedIndex) {
//                    Box(
//                        modifier = Modifier
//                            .size(10.dp)
//                            .clip(CircleShape)
//                            .background(color = Color.DarkGray)
//                    )
//                } else {
//                    Box(
//                        modifier = Modifier
//                            .size(10.dp)
//                            .clip(CircleShape)
//                            .background(color = Color.LightGray)
//                    )
//                }
//
//                if (index != totalDots - 1) {
//                    Spacer(modifier = Modifier.padding(horizontal = 2.dp))
//                }
//            }
//        }
//    }

}


fun mainContent() {


}

@Preview
@Composable
fun MyHomeScreenPreview() {
    val navController = rememberNavController()

    JetpackExampleTheme {
        Surface {
            HomeActivity(navController)
        }
    }
}
