package com.route.domin.useCase.localStorage

import com.route.domin.localStorage.PrefsHelper
import javax.inject.Inject

class GetTokenUseCase @Inject constructor(private val prefsHelper: PrefsHelper) {
    suspend fun invoke():String{
        return prefsHelper.getToken()
    }
}