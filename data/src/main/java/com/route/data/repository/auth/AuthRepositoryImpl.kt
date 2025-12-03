package com.route.data.repository.auth

import com.route.domin.base.Resource
import com.route.domin.dataSource.auth.AuthRemoteDataSource
import com.route.domin.localStorage.PrefsHelper
import com.route.domin.entities.auth.AuthResponseEntity
import com.route.domin.entities.auth.request.LoginRequestEntity
import com.route.domin.entities.auth.request.RegisterRequestEntity
import com.route.domin.repository.auth.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val prefsHelper: PrefsHelper
) : AuthRepository {
    override suspend fun login(request: LoginRequestEntity): Resource<AuthResponseEntity?> {
        val response = authRemoteDataSource.login(request)

        if (response is Resource.Success) {
            response.data?.token?.let { token ->
                prefsHelper.setToken(token)
            }
        }

        return response
    }

    override suspend fun register(request: RegisterRequestEntity): Resource<AuthResponseEntity?> {
        val response = authRemoteDataSource.register(request)

        if (response is Resource.Success) {
            response.data?.token?.let { token ->
                prefsHelper.setToken(token)
            }
        }

        return response

    }
}