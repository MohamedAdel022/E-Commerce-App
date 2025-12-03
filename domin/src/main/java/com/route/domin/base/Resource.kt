package com.route.domin.base

sealed interface Resource<T> {
//    class Initial<T> : Resource<T>
//    class Loading<T> : Resource<T>

    data class Success<T>(val data: T) : Resource<T>

    data class Failure<T>(val message: String) : Resource<T>
}


fun <T, R> Resource<T>.map(mapper: (T) -> R): Resource<R> {

    return when (this) {
        //        is Resource.Initial -> Resource.Initial()
        //        is Resource.Loading -> Resource.Loading()
        is Resource.Failure -> Resource.Failure(this.message)
        is Resource.Success -> Resource.Success(mapper(data))

    }
}