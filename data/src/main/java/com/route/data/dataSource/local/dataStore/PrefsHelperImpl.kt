package com.route.data.dataSource.local.dataStore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.route.data.remote.TokenProvider
import com.route.domin.localStorage.PrefsHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class PrefsHelperImpl @Inject constructor(
    private val prefs: DataStore<Preferences>,
    private val tokenProvider: TokenProvider
) : PrefsHelper {
    init {
        // Observe token forever
        CoroutineScope(Dispatchers.IO).launch {
            prefs.data.collect { preferences ->
                tokenProvider.token = preferences[TOKEN_KEY]
            }
        }
    }

    companion object {
        val TOKEN_KEY = stringPreferencesKey("token")
    }

    override suspend fun getToken(): String {
        return prefs.data.map { prefs ->
            prefs[TOKEN_KEY]
        }.first() ?: ""

    }

    override suspend fun setToken(token: String) {
        prefs.updateData { prefs ->
            prefs.toMutablePreferences().also { mutablePreferences ->
                mutablePreferences[TOKEN_KEY] = token
            }
        }
    }

    override suspend fun deleteToken(): Boolean {
        prefs.edit { prefs ->
            prefs.remove(TOKEN_KEY)
        }
        return true
    }
}