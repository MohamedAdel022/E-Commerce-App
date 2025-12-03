package com.route.domin.useCase.localStorage

import com.route.domin.localStorage.PrefsHelper
import javax.inject.Inject

class SetTokenUseCase @Inject constructor(private val prefsHelper: PrefsHelper) {
    suspend fun invoke(token: String) {
        prefsHelper.setToken(token)
    }
}