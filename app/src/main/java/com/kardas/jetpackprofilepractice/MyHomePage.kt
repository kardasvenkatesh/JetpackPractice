package com.kardas.jetpackprofilepractice

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.example.navigationdrawercomposeexample.R
import com.kardas.jetpackexample.ui.theme.JetpackExampleTheme
import com.kardas.jetpackprofilepractice.Data.CategoriesItem
import com.kardas.jetpackprofilepractice.Data.ProductsItem
import com.kardas.jetpackprofilepractice.model.CategoryViewModel
import com.kardas.jetpackprofilepractice.model.ProductsViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.delay

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MyHomePage(navController: NavController) {

//    val mainViewModel by viewModels<MainViewModel>()
    val mainViewModel: CategoryViewModel = viewModel()
    mainViewModel!!.getAllCategories()

    val productViewModel: ProductsViewModel = viewModel()
    productViewModel!!.getAllProducts()

    var count = "5"

    JetpackExampleTheme() {

        Scaffold(topBar = { MyTopAppBar("My Home") }) {

            SwipeRefreshCompose()

            Box(modifier = Modifier.fillMaxSize()) {


                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = colorResource(id = R.color.dark_grey))
                        .padding(0.dp, 60.dp, 0.dp, 0.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {



                    val state = rememberPagerState()
                    Column(modifier = Modifier.background(color = colorResource(id = R.color.dark_grey))) {


                        if (mainViewModel != null) {
                            SliderView(state, mainViewModel)
                        }

                        Spacer(modifier = Modifier.padding(5.dp))

                        DotsIndicator(
                            totalDots = mainViewModel?.categoryListResponse!!.size,
                            selectedIndex = state.currentPage
                        )

                        LazyRow() {
                            items(mainViewModel.categoryListResponse) {

                                    item ->
                                CategoriesCard(categoriesItem = item)
                            }

                        }

//                        LaunchedEffect(Unit) {
//                            val response = apiService!!.getAllProducts() // Make your API call here
//                            productViewModel.productListResponse = response.take(5) // Take only the first 5 elements from the API response
//                        }

                        Spacer(modifier = Modifier.padding(10.dp))

                        LazyColumn() {
                            items(productViewModel.productListResponse) {

                                    item ->
                                ProductsCard(productsItem = item, navController, count)
                            }

                        }

//                        PullRefreshIndicator(refreshing, pullRefreshState, Modifier.align(Alignment.TopCenter))
                    }

                    LaunchedEffect(key1 = state.currentPage) {
                        delay(3000)
                        var newPosition = state.currentPage + 1
                        if (newPosition > mainViewModel?.categoryListResponse!!.size - 1) newPosition =
                            0
                        state.animateScrollToPage(newPosition)
                    }
                }
            }
        }


    }


}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SliderView(state: PagerState, viewModel: CategoryViewModel) {

    val imageUrl = remember { mutableStateOf("") }
    HorizontalPager(
        state = state,
        count = viewModel.categoryListResponse.size,
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
    ) { page ->
        imageUrl.value = viewModel.categoryListResponse[page].image

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(contentAlignment = Alignment.BottomCenter) {

                val painter = rememberImagePainter(data = imageUrl.value, builder = {
//                    placeholder(R.drawable.ic_launcher_background)
                })
                Image(
                    painter = painter,
                    contentDescription = "",
                    Modifier
                        .padding(8.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

//                Text(
//                    text = viewModel.categoryListResponse[page].name,
//                    Modifier
//                        .fillMaxWidth()
//                        .height(60.dp)
//                        .padding(8.dp)
//                        .background(Color.LightGray)
//                        .padding(8.dp),
//                    textAlign = TextAlign.Start,
//                    fontSize = 18.sp,
//                    fontWeight = FontWeight.Medium
//                )
            }


        }


    }
}

@Composable
fun CategoriesCard(categoriesItem: CategoriesItem) {

    Column(
        modifier = Modifier
            .height(130.dp)
            .width(100.dp)
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = categoriesItem.image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .border(
                    width = 1.dp, color = Color.LightGray, shape = CircleShape
                )
                .padding(3.dp)
                .clip(CircleShape)
        )
        Text(
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(5.dp),
            textAlign = TextAlign.Center,
            text = categoriesItem.name,
            style = TextStyle(color = White, fontSize = 12.sp)
        )
//            Row(modifier = Modifier.padding(0.dp)) {
//                Column(modifier = Modifier.weight(1f)) {
//                    Text(
//                        text = categoriesItem.name, style = TextStyle(
//                            color = DarkGray, fontSize = 12.sp, fontWeight = FontWeight.Medium
//                        )
//                    )
//
//                }
////
//            }
    }

//    Card(
//
//        shape = RoundedCornerShape(20.dp), elevation = CardDefaults.cardElevation(
//            defaultElevation = 10.dp
//        ), modifier = Modifier
//            .fillMaxWidth()
//            .background(colorResource(id = R.color.bg_color))
//            .padding(5.dp)
//    ) {
//
//    }
}

@Composable
fun ProductsCard(productsItem: ProductsItem, navController: NavController, count: String) {

    Card(

        shape = RoundedCornerShape(20.dp), elevation = CardDefaults.cardElevation(
            defaultElevation = 50.dp
        ), modifier = Modifier
            .height(120.dp)
            .padding(10.dp)
            .clickable {


//                navController.navigate(Routes.ProductDetails.route + ?"title" = ${productsItem.title}")
//                navController.navigate("ProductDetail" + "3")
//                navController.navigate("ProductDetail")
                Log.d("imagesenfding", "," + "${productsItem.images.get(0)}")

                val image = productsItem.images.get(0)


//                navController.navigate(Routes.ProductDetails.route + "/name=${productsItem.title}?category=${productsItem.category}")
                navController.navigate(
                    Routes.ProductDetails.route + "/${productsItem.title}?${productsItem.price.toString()}?${productsItem.category.name}?${productsItem.description}?${productsItem.id}?${
                        productsItem.images.get(0)
                    }"
                )
                Log.d("pricesss",
                    productsItem.price.toString() + "," + { productsItem.category.name } + ", " + productsItem.images.get(
                        0
                    ) + ", " + productsItem.category.image)


            }) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(0.dp)
                .background(colorResource(id = R.color.dark_grey_light)),
        ) {
            AsyncImage(

                model = productsItem.images.get(0),
                contentDescription = null,
                modifier = Modifier
                    .height(70.dp)
                    .width(90.dp)
                    .padding(start = 15.dp)
                    .align(alignment = Alignment.CenterVertically)
                    .clip(RoundedCornerShape(15.dp))

            )
            Row(
                modifier = Modifier
                    .padding(start = 30.dp)
                    .align(alignment = Alignment.CenterVertically)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = productsItem.title, style = TextStyle(
                            color = White, fontSize = 14.sp, fontWeight = FontWeight.SemiBold
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "$" + productsItem.price.toString(), style = TextStyle(
                            color = White, fontSize = 14.sp
                        )
                    )

                    Text(
                        text = "381 KM away", style = TextStyle(
                            color = White, fontSize = 14.sp
                        )
                    )
                }
//                IconButton(
//                    onClick = { }, modifier = Modifier.background(
//                        color = colorPrimary, shape = RoundedCornerShape(10.dp)
//                    )
//                ) {
//                    Icon(Icons.Default.Add, tint = Color.White, contentDescription = null)
//                }
            }
        }
    }
}

@Composable
fun DotsIndicator(
    totalDots: Int, selectedIndex: Int
) {

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.Center
    ) {

        items(totalDots) { index ->
            if (index == selectedIndex) {
                Box(
                    modifier = Modifier
                        .size(6.dp)
                        .clip(CircleShape)
                        .background(color = Color.DarkGray)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(6.dp)
                        .clip(CircleShape)
                        .background(color = Color.LightGray)
                )
            }

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(topBarText: String) {
    val contextForToast = LocalContext.current.applicationContext
    TopAppBar(
        title = { Text(topBarText, style = TextStyle(fontSize = 20.sp, color = Color.White)) },
        actions = {
            // search icon
//            TopAppBarActionButton(
//
//                imageVector = Icons.Outlined.Search, description = "Search"
//            ) {
//                Toast.makeText(contextForToast, "Search Click", Toast.LENGTH_SHORT).show()
//            }

            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    Icons.Filled.Search, "contentDescription", tint = Color.White
                )
            }

            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    Icons.Filled.Settings, "contentDescription", tint = Color.White
                )
            }


//            // lock icon
//            TopAppBarActionButton(
//                imageVector = Icons.Outlined.Lock, description = "Lock"
//            ) {
//                Toast.makeText(contextForToast, "Lock Click", Toast.LENGTH_SHORT).show()
//            }
        },
        modifier = Modifier.background(color = colorResource(id = R.color.dark_grey)),
        colors = TopAppBarDefaults.smallTopAppBarColors(colorResource(id = R.color.dark_grey))
    )
}

@Composable
fun TopAppBarActionButton(
    imageVector: ImageVector, description: String, onClick: () -> Unit
) {
    IconButton(onClick = {
        onClick()
    }) {
        Icon(imageVector = imageVector, contentDescription = description)
    }
}


@Composable
fun SwipeRefreshCompose() {

    var refreshing by remember { mutableStateOf(false) }
    LaunchedEffect(refreshing) {
        if (refreshing) {
            delay(3000)
            refreshing = false
        }
    }

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = refreshing),
        onRefresh = { refreshing = true },
    ) {

        Column {
            Text(
                text = "Swipe to refresh UX",
                color = Color.Black,
                fontSize = 22.sp,
                letterSpacing = 2.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            )

            Spacer(modifier = Modifier.padding(2.dp))

            LazyColumn {

                items(count = 10) {

                    Column(
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.location),
                                contentDescription = "Profile Image",
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .size(70.dp)
                                    .clip(CircleShape)
                            )

                            Spacer(modifier = Modifier.padding(5.dp))

                            Column {
                                Text(
                                    text = "Bolt UIX",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.headlineSmall,
                                    letterSpacing = 2.sp
                                )

                                Spacer(modifier = Modifier.padding(2.dp))

                                Text(
                                    text = "Get started with Beautiful UI UX design patterns.",
                                    color = Color.Gray,
                                    style = MaterialTheme.typography.bodyLarge,
                                    letterSpacing = 1.sp
                                )
                            }
                        }
                    }

                    ListDivider()


                }
            }


        }

    }

}

@Composable
fun ListDivider() {
    Divider(
        modifier = Modifier.padding(horizontal = 14.dp),
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08f)
    )
}

@Composable
private fun CircularProgressAnimated() {
    val progressValue = 0.75f
    val infiniteTransition = rememberInfiniteTransition()

    val progressAnimationValue by infiniteTransition.animateFloat(
        initialValue = 0.0f,
        targetValue = progressValue,
        animationSpec = infiniteRepeatable(animation = tween(900))
    )

    CircularProgressIndicator(progress = progressAnimationValue)
}

