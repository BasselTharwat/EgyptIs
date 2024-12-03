package com.example.egyptis.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


/**
 * A class which represents a monument
 */
data class Monument(
    val id: Int,
    val category: MonumentCategory,
    @StringRes val name: Int,
    @StringRes val description: Int,
    @StringRes val location: Int,
    @DrawableRes val image: Int
)
