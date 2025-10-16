package com.youkydesign.mira.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.youkydesign.mira.ui.screens.scanner.FridgeScannerScreen
import com.youkydesign.mira.ui.screens.scanner.ScanResultScreen
import kotlinx.serialization.Serializable

sealed class MiraEntries : NavKey {
    @Serializable
    data object FridgeScanner : MiraEntries()

    @Serializable
    data object ScannerResult : MiraEntries()
}

@Composable
fun MiraNavigation() {
    val backStack = rememberNavBackStack(MiraEntries.FridgeScanner)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<MiraEntries.FridgeScanner> {
                FridgeScannerScreen(onScan = {
                    backStack.add(MiraEntries.ScannerResult)
                })
            }
            entry<MiraEntries.ScannerResult> {
                ScanResultScreen(onRetry = {
                    backStack.remove(MiraEntries.ScannerResult)
                })
            }
        }
    )
}