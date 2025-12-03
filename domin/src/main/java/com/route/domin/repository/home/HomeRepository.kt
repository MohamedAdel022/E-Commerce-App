package com.route.domin.repository.home

import com.route.domin.base.Resource
import com.route.domin.entities.category.response.CategoriesResponseEntity
import com.route.domin.entities.common.CategoryDataEntity
import com.route.domin.entities.products.response.ProductDataItemEntity
import com.route.domin.entities.products.response.ProductsResponseEntity

interface HomeRepository {
    suspend fun getCategories (): Resource< List<CategoryDataEntity?>?>
    suspend fun getProducts(
        categoryId: String? = null,
        subcategoryId: String? = null,
    ): Resource< List<ProductDataItemEntity?>?>
    suspend fun getSubCategory(categoryId: String): Resource< List<CategoryDataEntity?>?>
}



