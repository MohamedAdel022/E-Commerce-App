package com.route.data.models.products.response

import com.google.gson.annotations.SerializedName
import com.route.data.models.common.MetadataModel

data class ProductsResponseModel(

    @field:SerializedName("metadata")
	val metadata: MetadataModel? = null,

    @field:SerializedName("data")
	val data: List<ProductDataItemModel?>? = null,

    @field:SerializedName("results")
	val results: Int? = null
)