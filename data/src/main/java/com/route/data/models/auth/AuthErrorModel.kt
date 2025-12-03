package com.route.data.models.auth

import com.google.gson.annotations.SerializedName

data class AuthErrorModel(

	@field:SerializedName("statusMsg")
	val statusMsg: String? = null,

	@field:SerializedName("message")
	val message: String? = null
)