package com.example.egyptis.data.local

import com.example.egyptis.R
import com.example.egyptis.data.model.MonumentCategory
import com.example.egyptis.data.model.MonumentCategoryEnum

/**
 * An static data store of [Category]s.
 */
object LocalCategoryDataProvider {
    val defaultCategory = MonumentCategory(
        id = -1,
        name = MonumentCategoryEnum.PHARAOHS,
        icon = -1
    )

    val allCategories = listOf(
        MonumentCategory(
            id = 0,
            name = MonumentCategoryEnum.PHARAOHS,
            icon = R.drawable.pharaoh
        ),
        MonumentCategory(
            id = 1,
            name = MonumentCategoryEnum.VACATIONS,
            icon = R.drawable.vacations
        ),
        MonumentCategory(
            id = 2,
            name = MonumentCategoryEnum.CHURCHES,
            icon = R.drawable.cross
        ),
        MonumentCategory(
            id = 3,
            name = MonumentCategoryEnum.MOSQUES,
            icon = R.drawable.moon
        )
    )

    /**
     * Get a [Category] with the given [id].
     */
    fun get(id: Int): MonumentCategory? {
        return allCategories.firstOrNull { it.id == id }
    }

}