package com.route.data.repository.home

import com.route.domin.base.Resource
import com.route.domin.dataSource.home.HomeRemoteDataSource
import com.route.domin.entities.common.CategoryDataEntity
import com.route.domin.entities.products.response.ProductDataItemEntity
import com.route.domin.repository.home.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeRemoteDataSource: HomeRemoteDataSource
) : HomeRepository {
    override suspend fun getCategories(): Resource<List<CategoryDataEntity?>?> {
        return when (val response = homeRemoteDataSource.getCategories()) {
            is Resource.Success -> {
                Resource.Success(response.data?.data)
            }

            is Resource.Failure -> {
                Resource.Failure(response.message)
            }

        }

    }

    override suspend fun getProducts(
        categoryId: String?,
        subcategoryId: String?
    ): Resource<List<ProductDataItemEntity?>?> {
        return when (val response = homeRemoteDataSource.getProducts(categoryId, subcategoryId)) {
            is Resource.Success -> {
                Resource.Success(response.data?.data)
            }

            is Resource.Failure -> {
                Resource.Failure(response.message)
            }

        }


    }

    override suspend fun getSubCategory(categoryId: String): Resource<List<CategoryDataEntity?>?> {
        return when (val response = homeRemoteDataSource.getSubCategory(categoryId)) {
            is Resource.Failure -> {
                Resource.Failure(response.message)
            }

            is Resource.Success -> {
                Resource.Success(response.data?.data)
            }
        }
    }
}