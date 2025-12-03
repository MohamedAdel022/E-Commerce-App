package com.route.domin.localStorage

interface PrefsHelper {
    suspend fun getToken(): String
    suspend fun setToken(token: String)
    suspend fun deleteToken(): Boolean
}