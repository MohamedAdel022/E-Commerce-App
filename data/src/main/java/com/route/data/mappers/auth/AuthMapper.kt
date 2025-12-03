package com.route.data.mappers.auth

import com.route.data.models.auth.AuthResponseModel
import com.route.data.models.auth.UserModel
import com.route.data.models.auth.request.LoginRequestModel
import com.route.data.models.auth.request.RegisterRequestModel
import com.route.domin.entities.auth.AuthResponseEntity
import com.route.domin.entities.auth.UserEntity
import com.route.domin.entities.auth.request.LoginRequestEntity
import com.route.domin.entities.auth.request.RegisterRequestEntity


fun LoginRequestEntity.toModel() : LoginRequestModel{
    return LoginRequestModel(
        email = email,
        password = password
    )
}

fun RegisterRequestEntity.toModel(): RegisterRequestModel = RegisterRequestModel(
    email = email,
    password = password,
    phone = phone,
    rePassword = rePassword,
    name = name
)

fun AuthResponseModel.toEntity(): AuthResponseEntity = AuthResponseEntity(
    message = message,
    token = token,
    user = user?.toEntity()
)

fun UserModel.toEntity() : UserEntity = UserEntity(
    email = email,
    name = name,
    role = role
)



