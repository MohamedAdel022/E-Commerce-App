package com.route.domin.entities.category.response

import com.route.domin.entities.common.CategoryDataEntity
import com.route.domin.entities.common.MetadataEntity


data class CategoriesResponseEntity(
    val metadata: MetadataEntity? = null,
    val data: List<CategoryDataEntity?>? = null,
    val results: Int? = null
)




