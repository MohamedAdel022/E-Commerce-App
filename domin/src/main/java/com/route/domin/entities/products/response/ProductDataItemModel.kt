package com.route.domin.entities.products.response

import com.route.domin.entities.common.CategoryDataEntity

data class ProductDataItemEntity(
    val sold: Int? = null,
    val images: List<String?>? = null,
    val quantity: Int? = null,
    val availableColors: List<Any?>? = null,
    val imageCover: String? = null,
    val description: String? = null,
    val title: String? = null,
    val ratingsQuantity: Int? = null,
    val ratingsAverage: Any? = null,
    val createdAt: String? = null,
    val price: Int? = null,
    val id: String? = null,
    val subcategory: List<CategoryDataEntity?>? = null,
    val category: CategoryDataEntity? = null,
    val brand: CategoryDataEntity? = null,
    val slug: String? = null,
    val updatedAt: String? = null,
    val priceAfterDiscount: Int? = null
)