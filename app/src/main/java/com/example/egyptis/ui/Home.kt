package com.example.egyptis.ui

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.egyptis.data.local.LocalCategoryDataProvider
import com.example.egyptis.data.local.LocalMonumentsDataProvider
import com.example.egyptis.data.model.MonumentCategory

@Composable
fun Home(
    monumentUIState: MonumentUIState,
    modifier: Modifier = Modifier,
    onCategoryClick: (MonumentCategory) -> Unit
) {
    val categories = monumentUIState.categories
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 140.dp),
        modifier = modifier
    ) {
        items(categories) { category ->
            @DrawableRes val iconId = category.icon
            val icon = painterResource(id = iconId)

            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { onCategoryClick(category) },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = icon,
                    contentDescription = null
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreview() {
    Home(
        monumentUIState = MonumentUIState(
            monuments = LocalMonumentsDataProvider.allMonuments,
            categories = LocalCategoryDataProvider.allCategories,
            currentCategory = LocalCategoryDataProvider.allCategories[0],
            currentMonument = LocalMonumentsDataProvider.allMonuments[4]
        ),
        onCategoryClick = {}
    )
}

