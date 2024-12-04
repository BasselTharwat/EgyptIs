package com.example.egyptis.ui

import com.example.egyptis.data.local.LocalCategoryDataProvider
import com.example.egyptis.data.local.LocalMonumentsDataProvider
import com.example.egyptis.data.model.Monument
import com.example.egyptis.data.model.MonumentCategory
import com.example.egyptis.data.model.MonumentCategoryEnum

data class MonumentUIState(
    val monuments: List<Monument> = emptyList(),
    val categories: List<MonumentCategory> = emptyList(),
    val currentCategory: MonumentCategory = LocalCategoryDataProvider.defaultCategory,
    val currentMonument: Monument = LocalMonumentsDataProvider.defaultMonument,

    ) {

}