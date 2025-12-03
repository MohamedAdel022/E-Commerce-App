package com.route.domin.repository.auth

import com.route.domin.base.Resource
import com.route.domin.entities.auth.AuthResponseEntity
import com.route.domin.entities.auth.request.LoginRequestEntity
import com.route.domin.entities.auth.request.RegisterRequestEntity

interface AuthRepository {
    suspend fun login(request: LoginRequestEntity): Resource<AuthResponseEntity?>
    suspend fun register(request: RegisterRequestEntity): Resource<AuthResponseEntity?>

}