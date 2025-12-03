package com.route.data.models.category.response

import com.google.gson.annotations.SerializedName
import com.route.data.models.common.CategoryDataModel
import com.route.data.models.common.MetadataModel

data class CategoriesResponseModel(

    @field:SerializedName("metadata")
	val metadata: MetadataModel? = null,

    @field:SerializedName("data")
	val data: List<CategoryDataModel?>? = null,

    @field:SerializedName("results")
	val results: Int? = null
)




