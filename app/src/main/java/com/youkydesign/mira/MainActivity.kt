package com.youkydesign.mira

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.youkydesign.mira.ui.navigation.MiraNavigation
import com.youkydesign.mira.ui.theme.MiraAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiraAppTheme {
                MiraNavigation()
            }
        }
    }
}
