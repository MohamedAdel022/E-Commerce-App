package com.route.data.dataSource.remote.home

import com.route.data.base.BaseRemoteDataSource
import com.route.data.mappers.home.toEntity
import com.route.data.remote.api.CategoryService
import com.route.data.remote.api.ProductsService
import com.route.domin.base.Resource
import com.route.domin.base.map
import com.route.domin.dataSource.home.HomeRemoteDataSource
import com.route.domin.entities.category.response.CategoriesResponseEntity
import com.route.domin.entities.products.response.ProductsResponseEntity
import javax.inject.Inject

class HomeRemoteDataSourceImpl @Inject constructor(
    private val categoryService: CategoryService,
    private val productsService: ProductsService
): BaseRemoteDataSource(), HomeRemoteDataSource {
    override suspend fun getCategories(): Resource<CategoriesResponseEntity?> {
        return safeApiCall {
            categoryService.getCategories()
        }.map { it?.toEntity()
        }
    }

    override suspend fun getProducts(
        categoryId: String?,
        subcategoryId: String?
    ): Resource<ProductsResponseEntity?> {
        return safeApiCall {
            productsService.getProducts(categoryId, subcategoryId)
        }.map { it?.toEntity() }

    }

    override suspend fun getSubCategory(categoryId: String): Resource<CategoriesResponseEntity?> {
         return  safeApiCall {
              categoryService.getSupCategory(categoryId)
         }.map{
             it?.toEntity()
         }
    }
}