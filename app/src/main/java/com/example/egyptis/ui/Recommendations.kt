package com.example.egyptis.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.egyptis.data.local.LocalCategoryDataProvider
import com.example.egyptis.data.local.LocalMonumentsDataProvider
import com.example.egyptis.data.model.Monument
import com.example.egyptis.data.model.MonumentCategory

@Composable
fun Recommendations(
    monumentUIState: MonumentUIState,
    onMonumentClick: (Monument) -> Unit,
    modifier: Modifier = Modifier
) {
    val category = monumentUIState.currentCategory
    val recommendations = monumentUIState.monuments.filter { it.category == category }
    RecommendationList(
        recommendations = recommendations,
        onClick = onMonumentClick,
        modifier = modifier
    )

}

@Composable
fun RecommendationList(
    recommendations: List<Monument>,
    onClick: (Monument) -> Unit,
    modifier: Modifier
) {
    LazyColumn {
        items(recommendations) { recommendation ->
            RecommendationCard(
                onClick = { onClick(recommendation) },
                monument = recommendation
            )

        }
    }
}

@Composable
fun RecommendationCard(
    monument: Monument,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){

    Row (
        modifier = modifier
            .clickable{ onClick() }
    ){
        RecommendationImage(monumentImageId = monument.image)
        RecommendationText(monumentNameId = monument.name)

    }


}

@Composable
fun RecommendationText(
    modifier: Modifier = Modifier,
    @StringRes monumentNameId : Int
) {
    Text(text = stringResource(id = monumentNameId))

}

@Composable
fun RecommendationImage(
    modifier: Modifier = Modifier,
    @DrawableRes monumentImageId : Int
) {
    val image = painterResource(id = monumentImageId)
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .size(50.dp)
    )

}


@Preview (showBackground = true, showSystemUi = true)
@Composable
fun RecommendationsPreview() {
    Recommendations(monumentUIState = MonumentUIState(
        monuments = LocalMonumentsDataProvider.allMonuments,
        categories = LocalCategoryDataProvider.allCategories,
        currentCategory = LocalCategoryDataProvider.allCategories[0],
        currentMonument = LocalMonumentsDataProvider.allMonuments[4]
    ),
        onMonumentClick = {})
}
