package com.route.data.base

import com.google.gson.Gson
import com.route.data.models.auth.AuthErrorModel
import com.route.domin.base.Resource
import retrofit2.Response

open class BaseRemoteDataSource {
 suspend fun <T> safeApiCall(call: suspend () -> Response<T>): Resource<T?> {
        return try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                Resource.Success(body)
            } else {
                val error =
                    Gson().fromJson(response.errorBody()?.string(), AuthErrorModel::class.java)
                Resource.Failure(error.message ?: "something went wrong")

            }

        } catch (e: Exception) {
            Resource.Failure(e.message ?: "Unknown error")

        }
    }
}