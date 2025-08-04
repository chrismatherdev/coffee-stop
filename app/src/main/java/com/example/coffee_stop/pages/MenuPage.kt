package com.example.coffee_stop.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.coffee_stop.DataHandler
import com.example.coffee_stop.Product
import com.example.coffee_stop.ui.theme.Primary
import com.example.coffee_stop.ui.theme.Secondary

@Composable
fun MenuPage(dataHandler: DataHandler) {
    LazyColumn {
        items(dataHandler.menu) {
            Text(it.name,
                color = Primary,
                modifier = Modifier.padding(10.dp, 20.dp, 10.dp, 10.dp))
            it.products.forEach {
                Card(
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .background(Secondary)
                        .padding(12.dp)
                ) {
                    MenuItem(it, onAdd = {
                        dataHandler.cartAdd(it)
                    })
                }
            }
        }
    }
}

fun Double.format(digits: Int) = "%.${digits}f".format(this)

@Composable
fun MenuItem(
    product: Product,
    onAdd: (Product) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {

            AsyncImage(
                model = product.imageUrl,
                contentDescription = "Image for ${product.name}",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Column {
                    Text(product.name, fontWeight = FontWeight.Bold)
                    Text("$${product.price.format(2)} ea")
                }
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Secondary,
                        contentColor = Color.White
                    ),
                    onClick = {
                        onAdd(product)
                    },
                ) {
                    Text("Add")
                }
            }
        }
    }
}
