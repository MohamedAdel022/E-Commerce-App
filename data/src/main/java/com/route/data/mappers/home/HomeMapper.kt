package com.route.data.mappers.home

import com.route.data.models.category.response.CategoriesResponseModel
import com.route.data.models.common.CategoryDataModel
import com.route.data.models.common.MetadataModel
import com.route.data.models.products.response.ProductDataItemModel
import com.route.data.models.products.response.ProductsResponseModel
import com.route.domin.entities.category.response.CategoriesResponseEntity
import com.route.domin.entities.common.CategoryDataEntity
import com.route.domin.entities.common.MetadataEntity
import com.route.domin.entities.products.response.ProductDataItemEntity
import com.route.domin.entities.products.response.ProductsResponseEntity

fun CategoriesResponseModel.toEntity(): CategoriesResponseEntity = CategoriesResponseEntity(
    metadata = metadata?.toEntity(),
    data = data?.map { it?.toEntity() },
    results = results
)

fun MetadataModel.toEntity(): MetadataEntity = MetadataEntity(
    numberOfPages = numberOfPages,
    nextPage = nextPage,
    limit = limit,
    currentPage = currentPage
)

fun CategoryDataModel.toEntity(): CategoryDataEntity = CategoryDataEntity(
    image = image,
    createdAt = createdAt,
    name = name,
    id = id,
    slug = slug,
    updatedAt = updatedAt,
    category = category
)

fun ProductsResponseModel.toEntity(): ProductsResponseEntity = ProductsResponseEntity(
    metadata = metadata?.toEntity(),
    data = data?.map { it?.toEntity() },
    results = results
)

fun ProductDataItemModel.toEntity(): ProductDataItemEntity = ProductDataItemEntity(
    sold = sold,
    images = images,
    quantity = quantity,
    availableColors = availableColors,
    imageCover = imageCover,
    description = description,
    title = title,
    ratingsQuantity = ratingsQuantity,
    ratingsAverage = ratingsAverage,
    createdAt = createdAt,
    price = price,
    id = id,
    subcategory = subcategory?.map { it?.toEntity() },
    category = category?.toEntity(),
    brand = brand?.toEntity(),
    slug = slug,
    updatedAt = updatedAt,
    priceAfterDiscount = priceAfterDiscount
)