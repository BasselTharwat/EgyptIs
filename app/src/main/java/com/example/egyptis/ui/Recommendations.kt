package com.example.egyptis.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.egyptis.R
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
    LazyColumn (
        modifier = modifier
    ) {
        items(recommendations) { recommendation ->
            RecommendationCard(
                modifier = modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
                    .fillMaxSize(),
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

    Box (modifier = modifier
        .padding(dimensionResource(id = R.dimen.padding_small))
        .clip(MaterialTheme.shapes.medium)
        .background(color = MaterialTheme.colorScheme.surfaceDim)
    ){
        Row (
            modifier = modifier
                .clickable { onClick() }
                .padding(dimensionResource(id = R.dimen.padding_small)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start


        ){
            RecommendationImage(monumentImageId = monument.image)
            RecommendationText(monumentNameId = monument.name)

        }
    }



}

@Composable
fun RecommendationText(
    modifier: Modifier = Modifier,
    @StringRes monumentNameId : Int
) {
    Text(text = stringResource(id = monumentNameId),
        style = MaterialTheme.typography.titleLarge,
        textAlign = TextAlign.Left,
        modifier = modifier
            .padding(start = dimensionResource(id = R.dimen.padding_extra_large))
    )

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
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(dimensionResource(id = R.dimen.recommendation_image_size))
            .shadow(
                elevation = dimensionResource(id = R.dimen.recommendation_image_shadow_elevation),
                shape = CircleShape,
                spotColor = MaterialTheme.colorScheme.inverseSurface
            )
            .clip(CircleShape)
    )

}


@Preview (showBackground = true, showSystemUi = true)
@Composable
fun RecommendationsPreview() {
    Recommendations(monumentUIState = MonumentUIState(
        monuments = LocalMonumentsDataProvider.allMonuments,
        categories = LocalCategoryDataProvider.allCategories,
        currentCategory = LocalCategoryDataProvider.allCategories[3],
        currentMonument = LocalMonumentsDataProvider.allMonuments[4]
    ),
        onMonumentClick = {})
}
