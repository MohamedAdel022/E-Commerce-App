package com.route.e_commerce.utils

import android.util.Patterns

object ValidationUtils {

    /**
     * Validates email format
     * @return null if valid, error message otherwise
     */
    fun validateEmail(email: String): String? {
        return when {
            email.isEmpty() -> "Email is required"
            email.isBlank() -> "Email cannot be blank"
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Invalid email format"
            else -> null
        }
    }

    /**
     * Validates password with comprehensive rules
     * @return null if valid, error message otherwise
     */
    fun validatePassword(password: String): String? {
        return when {
            password.isEmpty() -> "Password is required"
            password.isBlank() -> "Password cannot be blank"
            password.length < 6 -> "Password must be at least 6 characters"
            password.length > 50 -> "Password must not exceed 50 characters"
            !password.any { it.isDigit() } -> "Password must contain at least one digit"
            !password.any { it.isUpperCase() } -> "Password must contain at least one uppercase letter"
            !password.any { it.isLowerCase() } -> "Password must contain at least one lowercase letter"
            else -> null
        }
    }

    /**
     * Validates password for login (less strict than registration)
     * @return null if valid, error message otherwise
     */
    fun validateLoginPassword(password: String): String? {
        return when {
            password.isEmpty() -> "Password is required"
            password.isBlank() -> "Password cannot be blank"
            password.length < 6 -> "Password must be at least 6 characters"
            else -> null
        }
    }

    /**
     * Validates full name
     * @return null if valid, error message otherwise
     */
    fun validateFullName(fullName: String): String? {
        return when {
            fullName.isEmpty() -> "Full name is required"
            fullName.isBlank() -> "Full name cannot be blank"
            fullName.length < 3 -> "Full name must be at least 3 characters"
            fullName.length > 50 -> "Full name must not exceed 50 characters"
            !fullName.all { it.isLetter() || it.isWhitespace() } -> "Full name can only contain letters and spaces"
            else -> null
        }
    }

    /**
     * Validates mobile number (Egyptian format)
     * @return null if valid, error message otherwise
     */
    fun validateMobileNumber(mobileNumber: String): String? {
        val cleanNumber = mobileNumber.replace(Regex("[\\s-]"), "")
        return when {
            mobileNumber.isEmpty() -> "Mobile number is required"
            mobileNumber.isBlank() -> "Mobile number cannot be blank"
            !cleanNumber.all { it.isDigit() } -> "Mobile number can only contain digits"
            cleanNumber.length < 11 -> "Mobile number must be at least 11 digits"
            cleanNumber.length > 11 -> "Mobile number must not exceed 11 digits"
            !cleanNumber.startsWith("01") -> "Mobile number must start with 01"
            else -> null
        }
    }
}

