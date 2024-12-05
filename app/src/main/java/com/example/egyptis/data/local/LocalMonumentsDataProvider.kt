package com.example.egyptis.data.local

import com.example.egyptis.R
import com.example.egyptis.data.model.Monument
import com.example.egyptis.data.model.MonumentCategory
import com.example.egyptis.data.model.MonumentCategoryEnum

/**
 * An static data store of [Monuments]s.
 */
object LocalMonumentsDataProvider {
    val defaultMonument = Monument(
        id = -1,
        category = MonumentCategory(
            id = -1,
            name = MonumentCategoryEnum.PHARAOHS,
            icon = -1
        ),
        name = -1,
        description = -1,
        location = -1,
        image = -1
    )

    val allMonuments = listOf(
        Monument(
            id = 0,
            category = LocalCategoryDataProvider.get(0)?: LocalCategoryDataProvider.defaultCategory,
            name = R.string.Monument_1_name,
            description = R.string.Monument_1_description,
            location = R.string.Monument_1_location,
            image = R.drawable.sphinx
        ),
        Monument(
            id = 1,
            category = LocalCategoryDataProvider.get(0)?: LocalCategoryDataProvider.defaultCategory,
            name = R.string.Monument_2_name,
            description = R.string.Monument_2_description,
            location = R.string.Monument_2_location,
            image = R.drawable.abu_simbel
        ),
        Monument(
            id = 2,
            category = LocalCategoryDataProvider.get(0)?: LocalCategoryDataProvider.defaultCategory,
            name = R.string.Monument_3_name,
            description = R.string.Monument_3_description,
            location = R.string.Monument_3_location,
            image = R.drawable.tutankhamon
        ),
        Monument(
            id = 3,
            category = LocalCategoryDataProvider.get(1)?: LocalCategoryDataProvider.defaultCategory,
            name = R.string.Monument_4_name,
            description = R.string.Monument_4_description,
            location = R.string.Monument_4_location,
            image = R.drawable.dahab
        ),
        Monument(
            id = 4,
            category = LocalCategoryDataProvider.get(1)?: LocalCategoryDataProvider.defaultCategory,
            name = R.string.Monument_5_name,
            description = R.string.Monument_5_description,
            location = R.string.Monument_5_location,
            image = R.drawable.hurghada
        ),
        Monument(
            id = 5,
            category = LocalCategoryDataProvider.get(1)?: LocalCategoryDataProvider.defaultCategory,
            name = R.string.Monument_6_name,
            description = R.string.Monument_6_description,
            location = R.string.Monument_6_location,
            image = R.drawable.sharm_el_sheikh
        ),
        Monument(
            id = 6,
            category = LocalCategoryDataProvider.get(2)?: LocalCategoryDataProvider.defaultCategory,
            name = R.string.Monument_7_name,
            description = R.string.Monument_7_description,
            location = R.string.Monument_7_location,
            image = R.drawable.st_catherine
        ),
        Monument(
            id = 7,
            category = LocalCategoryDataProvider.get(2)?: LocalCategoryDataProvider.defaultCategory,
            name = R.string.Monument_8_name,
            description = R.string.Monument_8_description,
            location = R.string.Monument_8_location,
            image = R.drawable.st_george_church
        ),
        Monument(
            id = 8,
            category = LocalCategoryDataProvider.get(2)?: LocalCategoryDataProvider.defaultCategory,
            name = R.string.Monument_9_name,
            description = R.string.Monument_9_description,
            location = R.string.Monument_9_location,
            image = R.drawable.moalaqa
        ),
        Monument(
            id = 9,
            category = LocalCategoryDataProvider.get(3)?: LocalCategoryDataProvider.defaultCategory,
            name = R.string.Monument_10_name,
            description = R.string.Monument_10_description,
            location = R.string.Monument_10_location,
            image = R.drawable.morsi_abu_el_abbas
        ),
        Monument(
            id = 10,
            category = LocalCategoryDataProvider.get(3)?: LocalCategoryDataProvider.defaultCategory,
            name = R.string.Monument_11_name,
            description = R.string.Monument_11_description,
            location = R.string.Monument_11_location,
            image = R.drawable.muhammad_ali_mosque
        ),
        Monument(
            id = 11,
            category = LocalCategoryDataProvider.get(3)?: LocalCategoryDataProvider.defaultCategory,
            name = R.string.Monument_12_name,
            description = R.string.Monument_12_description,
            location = R.string.Monument_12_location,
            image = R.drawable.salah_el_din_mosque
        )
    )

    /**
     * Get a [Monument] with the given [id].
     */
    fun get(id: Int): Monument? {
        return allMonuments.firstOrNull { it.id == id }
    }

    /**
     * Get [Monuments] with the given [category].
     */
    fun get(category: MonumentCategory): List<Monument> {
        return allMonuments.filter { it.category == category }
    }
    
    
    
}