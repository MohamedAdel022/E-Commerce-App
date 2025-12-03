package com.route.domin.useCase.auth

import com.route.domin.base.Resource
import com.route.domin.entities.auth.AuthResponseEntity
import com.route.domin.entities.auth.request.LoginRequestEntity
import com.route.domin.repository.auth.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val authRepository: AuthRepository) {
    suspend fun invoke(request: LoginRequestEntity): Resource<AuthResponseEntity?> {
        return authRepository.login(request)
    }
}
