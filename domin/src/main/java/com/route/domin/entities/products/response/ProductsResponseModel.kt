package com.route.domin.entities.products.response

import com.route.domin.entities.common.MetadataEntity

data class ProductsResponseEntity(
    val metadata: MetadataEntity? = null,
    val data: List<ProductDataItemEntity?>? = null,
    val results: Int? = null
)