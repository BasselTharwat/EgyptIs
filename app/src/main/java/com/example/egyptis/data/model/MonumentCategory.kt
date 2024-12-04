package com.example.egyptis.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

enum class MonumentCategoryEnum {
    PHARAOHS, VACATIONS, CHURCHES, MOSQUES
}

data class MonumentCategory (
    val id: Int,
    val name: MonumentCategoryEnum,
    @DrawableRes val icon: Int
)