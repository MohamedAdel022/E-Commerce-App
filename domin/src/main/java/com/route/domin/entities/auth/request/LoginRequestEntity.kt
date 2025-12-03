package com.route.domin.entities.auth.request

data class LoginRequestEntity(
	val password: String? = null,
	val email: String? = null
)

