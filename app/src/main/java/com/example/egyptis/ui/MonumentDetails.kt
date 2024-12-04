package com.example.egyptis.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.egyptis.R
import com.example.egyptis.data.local.LocalMonumentsDataProvider
import com.example.egyptis.data.model.Monument
import com.example.egyptis.ui.theme.EgyptIsTheme

@Composable
fun MonumentDetails(
    modifier: Modifier = Modifier,
    monument: Monument
){

    Column (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        @DrawableRes val imageId = monument.image
        val image = painterResource(id = imageId)
        Image(
            painter = image,
            contentDescription = null
        )

        @StringRes val nameId = monument.name
        Text(text = stringResource(id = nameId),
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            modifier = Modifier.padding(top = 10.dp))

        @StringRes val descriptionId = monument.description
        Text(text = stringResource(id = descriptionId))


    }




}



@Preview (showBackground = true, showSystemUi = true)
@Composable
fun MonumentDetailsPreview() {
    MonumentDetails(monument = LocalMonumentsDataProvider.allMonuments[11])
}




