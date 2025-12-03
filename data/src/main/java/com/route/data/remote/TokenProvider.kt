package com.route.data.remote

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenProvider @Inject constructor() {

    @Volatile
    var token: String? = null
}