package com.youkydesign.nav3.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.youkydesign.nav3.ui.screens.feature_1.FirstScreen
import com.youkydesign.nav3.ui.screens.feature_1.SecondScreen
import kotlinx.serialization.Serializable

sealed class AppEntries : NavKey {
    @Serializable
    data object FridgeScanner : AppEntries()

    @Serializable
    data object ScannerResult : AppEntries()
}

@Composable
fun AppNavigation() {
    val backStack = rememberNavBackStack(AppEntries.FridgeScanner)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<AppEntries.FridgeScanner> {
                FirstScreen(onForward = {
                    backStack.add(AppEntries.ScannerResult)
                })
            }
            entry<AppEntries.ScannerResult> {
                SecondScreen(onBackward = {
                    backStack.remove(AppEntries.ScannerResult)
                })
            }
        }
    )
}