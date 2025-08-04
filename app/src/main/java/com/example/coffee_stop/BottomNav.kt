package com.example.coffee_stop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffee_stop.ui.theme.DarkPrimary
import com.example.coffee_stop.ui.theme.Primary
import com.example.coffee_stop.ui.theme.Secondary

data class NavPage(var name: String, var icon: ImageVector, var route: String)

object Routes {
    val MenuPage = NavPage("Menu", Icons.Outlined.Menu, "menu")
    val OffersPage = NavPage("Offers", Icons.Outlined.Star, "offers")
    val OrdersPage = NavPage("Orders", Icons.Outlined.ShoppingCart, "orders")
    val InfoPage = NavPage("Info", Icons.Outlined.Info, "info")

    val pages = listOf(MenuPage, OffersPage, OrdersPage, InfoPage)
}

@Preview
@Composable
fun NavItem_Preview() {
    NavItem(page = Routes.MenuPage, modifier = Modifier.padding(8.dp))
}

@Composable
fun Navbar(selectedRoute: String = Routes.MenuPage.route, onChange: (String)->Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .background(DarkPrimary)
            .padding(16.dp)
    ) {
        for(page in Routes.pages) {
            NavItem(
                modifier = Modifier.clickable {
                    onChange(page.route)
                },
                page,
                selected = selectedRoute == page.route
            )
        }
    }
}

@Composable
fun NavItem(
    modifier: Modifier = Modifier,
    page: NavPage,
    selected: Boolean = false,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(horizontal = 12.dp)
    ) {
        Image(
            imageVector = page.icon,
            contentDescription = page.name,
            colorFilter = ColorFilter.tint(
                if (selected) Secondary else Primary
            ),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .size(24.dp)
        )
        Text(
            text = page.name,
            fontSize = 12.sp,
            color = if (selected) Secondary else Primary
        )
    }
}