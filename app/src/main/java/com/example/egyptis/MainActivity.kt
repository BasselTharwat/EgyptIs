package com.example.egyptis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.EgyptIsTheme
import com.example.egyptis.ui.EgyptIsApp


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EgyptIsTheme {
                val layoutDirection = LocalLayoutDirection.current
                Scaffold(modifier = Modifier
                    .padding(
                    start = WindowInsets.safeDrawing.asPaddingValues()
                        .calculateStartPadding(layoutDirection),
                    end = WindowInsets.safeDrawing.asPaddingValues()
                        .calculateEndPadding(layoutDirection)
                ))
                { innerPadding ->
                    val windowSize = calculateWindowSizeClass(activity = this)
                    EgyptIsApp(
                        windowSize = windowSize.widthSizeClass,
                        modifier = Modifier.padding(innerPadding)
                            .background(color = MaterialTheme.colorScheme.surface)
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun EgyptIsCompactPreview() {
    EgyptIsTheme {
        Surface {
            EgyptIsApp(windowSize = WindowWidthSizeClass.Compact)
        }
    }
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun EgyptIsMediumPreview() {
    EgyptIsTheme {
        Surface {
            EgyptIsApp(windowSize = WindowWidthSizeClass.Medium)
        }
    }
}

@Preview(showBackground = true, widthDp = 1200)
@Composable
fun EgyptIsExpandedPreview() {
    EgyptIsTheme {
        Surface {
            EgyptIsApp(windowSize = WindowWidthSizeClass.Expanded)
        }
    }
}
