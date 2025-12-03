package com.route.data.dataSource.remote.auth

import com.route.data.base.BaseRemoteDataSource
import com.route.data.remote.api.AuthService
import com.route.data.mappers.auth.toEntity
import com.route.data.mappers.auth.toModel
import com.route.domin.base.Resource
import com.route.domin.base.map
import com.route.domin.dataSource.auth.AuthRemoteDataSource
import com.route.domin.entities.auth.AuthResponseEntity
import com.route.domin.entities.auth.request.LoginRequestEntity
import com.route.domin.entities.auth.request.RegisterRequestEntity
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(
    private val authService: AuthService
) : BaseRemoteDataSource(), AuthRemoteDataSource {
    override suspend fun login(request: LoginRequestEntity): Resource<AuthResponseEntity?> {
        return safeApiCall {
            authService.login(request.toModel())
        }.map { it?.toEntity() }
    }

    override suspend fun register(request: RegisterRequestEntity): Resource<AuthResponseEntity?> {
        return safeApiCall {
            authService.register(request.toModel())
        }.map { it?.toEntity() }
    }
}