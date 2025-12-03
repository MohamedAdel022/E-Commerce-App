package com.route.data.remote.api

import com.route.data.models.auth.AuthResponseModel
import com.route.data.models.auth.request.LoginRequestModel
import com.route.data.models.auth.request.RegisterRequestModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("auth/signin")
    suspend fun login(@Body request: LoginRequestModel): Response<AuthResponseModel>

    @POST("auth/signup")
    suspend fun register(@Body request: RegisterRequestModel): Response<AuthResponseModel>

}