package com.example.egyptis.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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

@Composable
fun MonumentDetails(
    modifier: Modifier = Modifier,
    monumentUIState: MonumentUIState
){

    Column (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val currentMonument = monumentUIState.currentMonument

        Spacer(modifier = modifier.weight(0.25f))

        @DrawableRes val imageId = currentMonument.image
        MonumentImage(imageId = imageId)

        Spacer(modifier = modifier.weight(0.5f))

        val nameId = currentMonument.name
        MonumentTitle(titleId = nameId)

        @StringRes val descriptionId = currentMonument.description
        @StringRes val locationId = currentMonument.location
        MonumentDescription(descriptionId = descriptionId,
            locationId = locationId)

        Spacer(modifier = modifier.weight(1.0f))

    }
}

@Composable
fun MonumentImage(
    @DrawableRes imageId: Int,
    modifier: Modifier = Modifier
){
    val image = painterResource(id = imageId)
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(dimensionResource(id = R.dimen.description_image_size))
            .shadow(
                elevation = dimensionResource(id = R.dimen.description_image_shadow_elevation),
                shape = MaterialTheme.shapes.extraLarge,
                spotColor = MaterialTheme.colorScheme.inverseSurface
            )
            .padding(dimensionResource(id = R.dimen.padding_medium))
            .clip(MaterialTheme.shapes.medium)
    )
}



@Composable
fun MonumentTitle(
    @StringRes titleId: Int,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier
        .padding(dimensionResource(id = R.dimen.padding_small))
        .clip(MaterialTheme.shapes.large)
        .background(color = MaterialTheme.colorScheme.surfaceDim)){
        Text(
            text = stringResource(id = titleId),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineLarge,
            modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium))
        )
    }
}

@Composable
fun MonumentDescription(
    @StringRes descriptionId: Int,
    @StringRes locationId: Int,
    modifier: Modifier = Modifier
){
    Box(modifier = modifier
        .padding(dimensionResource(id = R.dimen.padding_large))
        .clip(MaterialTheme.shapes.large)
        .background(color = MaterialTheme.colorScheme.surfaceVariant)){
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium))
        ) {
            Text(
                text = stringResource(id = descriptionId),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge,
            )
            Row (
                modifier = modifier.padding(top = dimensionResource(id = R.dimen.padding_medium))
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.location_icon_size))
                        .align(Alignment.CenterVertically)
                )
                Text(text = stringResource(id = locationId),
                    style = MaterialTheme.typography.labelSmall,
                    modifier = modifier.padding(start = dimensionResource(id = R.dimen.padding_small))
                )

            }


        }


    }

}



@Preview (showBackground = true, showSystemUi = true)
@Composable
fun MonumentDetailsPreview() {
    MonumentDetails(monumentUIState = MonumentUIState(
        monuments = LocalMonumentsDataProvider.allMonuments,
        categories = LocalCategoryDataProvider.allCategories,
        currentCategory = LocalCategoryDataProvider.allCategories[0],
        currentMonument = LocalMonumentsDataProvider.allMonuments[11]
    ))
}




