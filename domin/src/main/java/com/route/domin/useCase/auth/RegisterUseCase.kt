package com.route.domin.useCase.auth

import com.route.domin.base.Resource
import com.route.domin.entities.auth.AuthResponseEntity
import com.route.domin.entities.auth.request.RegisterRequestEntity
import com.route.domin.repository.auth.AuthRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val authRepository: AuthRepository) {
    suspend fun invoke(request: RegisterRequestEntity): Resource<AuthResponseEntity?> {
        return authRepository.register(request)

    }
}