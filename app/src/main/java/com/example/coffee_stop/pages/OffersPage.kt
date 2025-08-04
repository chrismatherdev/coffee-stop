package com.example.coffee_stop.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffee_stop.R
import com.example.coffee_stop.ui.theme.PrimaryContainer


@Preview(showBackground = true, widthDp = 400)
@Composable
private fun Offer_Preview() {
    Offer(title = "Coffee Shack", description = "Welcome to our coffee shop!")
}

@Preview(showBackground = true)
@Composable
fun OffersPage() {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
    ) {
        Offer(title = "Early Coffee", description = "10% off. Offer valid from 6am to 9am.")
        Offer(title = "Welcome Gift", description = "25% off on your first order.")
        Offer(title = "Repeat customer", description = "50% off on your tenth order.")
    }
}

@Composable
fun Offer(title: String, description: String) {
    Box(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.background_pattern),
            contentDescription = "background pattern",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth().height(140.dp)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(150.dp)
        ) {
            Text(
                text = title, style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(16.dp)
                    .background(PrimaryContainer)
            )
            Text(
                text = description, style = MaterialTheme.typography.titleSmall, modifier = Modifier
                    .padding(16.dp)
                    .background(PrimaryContainer)
            )
        }
    }
}