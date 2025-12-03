package com.route.data.remote.api

import com.route.data.models.category.response.CategoriesResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CategoryService {
    @GET("categories")
    suspend fun getCategories(): Response<CategoriesResponseModel>
    @GET("categories/{id}/subcategories")
    suspend fun getSupCategory(@Path("id") categoryId:String) : Response<CategoriesResponseModel>
}


