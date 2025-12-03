package com.route.data.remote.api

import com.route.data.models.products.response.ProductsResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductsService {
    @GET("products")
    suspend fun getProducts(
        @Query("category") categoryId: String?=null,
        @Query("category") subCategoryId: String?=null
    ): Response<ProductsResponseModel>
}
