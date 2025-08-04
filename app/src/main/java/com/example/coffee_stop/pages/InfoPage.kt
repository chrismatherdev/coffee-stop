package com.example.coffee_stop.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffee_stop.ui.theme.PrimaryContainer

@Composable
fun InfoPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "About CoffeeStop",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .background(PrimaryContainer)
                .padding(8.dp)
        )

        Text(
            text = "CoffeeStop is a personal project created to explore Android development using Jetpack Compose. It showcases various features like special offers, info pages, and web integrations.",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(vertical = 8.dp)
        )

        Text(
            text = "Thanks for checking it out!",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(top = 16.dp)
        )
    }
}

@Preview(showBackground = true, widthDp = 400)
@Composable
fun InfoPage_Preview() {
    InfoPage()
}