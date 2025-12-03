package com.route.domin.entities.auth

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AuthResponseEntity(
    val message: String? = null,
    val user: UserEntity? = null,
    val token: String? = null
) : Parcelable

@Parcelize
data class UserEntity(

	val role: String? = null,
	val name: String? = null,

	val email: String? = null
) : Parcelable
