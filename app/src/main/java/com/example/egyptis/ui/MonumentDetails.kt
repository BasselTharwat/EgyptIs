package com.example.egyptis.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.backgroundLight
import com.example.compose.onPrimaryContainerDark
import com.example.compose.onPrimaryContainerLight
import com.example.compose.onPrimaryLight
import com.example.compose.onTertiaryDark
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
        @DrawableRes val imageId = currentMonument.image
        val image = painterResource(id = imageId)
        Image(
            painter = image,
            contentDescription = null
        )

        @StringRes val nameId = currentMonument.name
        Text(text = stringResource(id = nameId),
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            modifier = Modifier.padding(top = 10.dp))

        @StringRes val descriptionId = currentMonument.description
        Text(text = stringResource(id = descriptionId))
    }




}



@Preview (showBackground = true, showSystemUi = true)
@Composable
fun MonumentDetailsPreview() {
    MonumentDetails(monumentUIState = MonumentUIState(
        monuments = LocalMonumentsDataProvider.allMonuments,
        categories = LocalCategoryDataProvider.allCategories,
        currentCategory = LocalCategoryDataProvider.allCategories[0],
        currentMonument = LocalMonumentsDataProvider.allMonuments[6]
    ))
}




