package com.youkydesign.mira.ui.screens.scanner

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FridgeScannerScreen(modifier: Modifier = Modifier, onScan: () -> Unit) {
    Scaffold { paddingValues ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp)
        ) {
            Column {
                Text("Fridge Scanner Screen")
                Button(onClick = onScan) {
                    Text("scan it")
                }
            }
        }
    }
}