package com.example.coffee_stop

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.coffee_stop.pages.InfoPage
import com.example.coffee_stop.pages.MenuPage
import com.example.coffee_stop.pages.OffersPage
import com.example.coffee_stop.pages.OrdersPage
import com.example.coffee_stop.ui.theme.DarkPrimary
import com.example.coffee_stop.ui.theme.Primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(dataHandler: DataHandler) {
    val selectedRoute = remember {
        mutableStateOf(Routes.MenuPage.route)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Primary,
                    titleContentColor = Primary,
                ),
                title = { AppTitle() }
            )
        },
        bottomBar = {
            Navbar(
                selectedRoute = selectedRoute.value,
                onChange = { route ->
                    selectedRoute.value = route
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(20.dp)
        ) {
            when (selectedRoute.value) {
                Routes.OffersPage.route -> OffersPage()
                Routes.MenuPage.route -> MenuPage(dataHandler)
                Routes.OrdersPage.route -> OrdersPage(dataHandler)
                Routes.InfoPage.route -> InfoPage()
            }
        }
    }
}

@Composable
fun AppTitle() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.tea),
                contentDescription = "Logo",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Coffee Stop",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold,
                color = DarkPrimary
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    val selectedRoute = remember {
        mutableStateOf(Routes.OffersPage.route)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Primary,
                    titleContentColor = Primary,
                ),
                title = { AppTitle() }
            )
        },
        bottomBar = {
            Navbar(
                selectedRoute = selectedRoute.value,
                onChange = { route ->
                    selectedRoute.value = route
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(20.dp)
        ) {
            when(selectedRoute.value) {
                Routes.OffersPage.route -> OffersPage()
                Routes.MenuPage.route -> Text("menu")
                Routes.OrdersPage.route -> Text("orders")
                Routes.InfoPage.route -> InfoPage()
            }
        }
    }
}

//@Preview(showBackground = true, widthDp = 400, heightDp = 1000)
//@Composable
//fun CoffeeStopAppPreview() {
//    CoffeeStopAppPreviewLayout()
//}
