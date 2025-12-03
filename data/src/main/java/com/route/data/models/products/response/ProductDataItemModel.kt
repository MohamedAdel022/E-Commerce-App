package com.route.data.models.products.response

import com.google.gson.annotations.SerializedName
import com.route.data.models.common.CategoryDataModel

data class ProductDataItemModel(

    @field:SerializedName("sold")
	val sold: Int? = null,

    @field:SerializedName("images")
	val images: List<String?>? = null,

    @field:SerializedName("quantity")
	val quantity: Int? = null,

    @field:SerializedName("availableColors")
	val availableColors: List<Any?>? = null,

    @field:SerializedName("imageCover")
	val imageCover: String? = null,

    @field:SerializedName("description")
	val description: String? = null,

    @field:SerializedName("title")
	val title: String? = null,

    @field:SerializedName("ratingsQuantity")
	val ratingsQuantity: Int? = null,

    @field:SerializedName("ratingsAverage")
	val ratingsAverage: Any? = null,

    @field:SerializedName("createdAt")
	val createdAt: String? = null,

    @field:SerializedName("price")
	val price: Int? = null,

    @field:SerializedName("id")
	val id: String? = null,

    @field:SerializedName("subcategory")
	val subcategory: List<CategoryDataModel?>? = null,

    @field:SerializedName("category")
	val category: CategoryDataModel? = null,

    @field:SerializedName("brand")
	val brand: CategoryDataModel? = null,

    @field:SerializedName("slug")
	val slug: String? = null,

    @field:SerializedName("updatedAt")
	val updatedAt: String? = null,

    @field:SerializedName("priceAfterDiscount")
	val priceAfterDiscount: Int? = null
)