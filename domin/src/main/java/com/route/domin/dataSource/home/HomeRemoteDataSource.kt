package com.route.domin.dataSource.home

import com.route.domin.base.Resource
import com.route.domin.entities.category.response.CategoriesResponseEntity
import com.route.domin.entities.products.response.ProductsResponseEntity

interface HomeRemoteDataSource {
    suspend fun getCategories(): Resource<CategoriesResponseEntity?>
    suspend fun getProducts(
        categoryId: String? = null,
        subcategoryId: String? = null,
    ): Resource<ProductsResponseEntity?>

    suspend fun getSubCategory(categoryId: String): Resource<CategoriesResponseEntity?>
}
