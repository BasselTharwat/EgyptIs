package com.example.egyptis.ui

import com.example.egyptis.data.local.LocalMonumentsDataProvider
import com.example.egyptis.data.model.Monument
import com.example.egyptis.data.model.MonumentCategory

data class MonumentUIState(
    val monuments: List<Monument> = emptyList(),
    val currentCategory: MonumentCategory = MonumentCategory.PHARAOHS,
    val currentMonument: Monument = LocalMonumentsDataProvider.defaultMonument,

    ) {

}