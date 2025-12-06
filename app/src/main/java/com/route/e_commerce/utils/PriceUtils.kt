package com.route.e_commerce.utils

import java.text.NumberFormat
import java.util.Locale

object PriceUtils {

    /**
     * Formats a price with thousand separators (e.g., 1,000)
     * @param price The price to format
     * @return Formatted price string with thousand separators
     */
    fun formatPrice(price: Number?): String {
        val formatter = NumberFormat.getNumberInstance(Locale.US)
        return formatter.format(price ?: 0)
    }

    /**
     * Formats a price with currency (EGP) and thousand separators
     * @param price The price to format
     * @param currency The currency symbol (default: "EGP")
     * @return Formatted price string with currency and thousand separators
     */
    fun formatPriceWithCurrency(price: Number?, currency: String = "EGP"): String {
        val formattedPrice = formatPrice(price)
        return "$currency $formattedPrice"
    }
}

