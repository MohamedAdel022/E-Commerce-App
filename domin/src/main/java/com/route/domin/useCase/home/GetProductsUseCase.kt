package com.route.domin.useCase.home

import com.route.domin.base.Resource
import com.route.domin.entities.products.response.ProductDataItemEntity
import com.route.domin.entities.products.response.ProductsResponseEntity
import com.route.domin.repository.home.HomeRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend fun invoke(
        categoryId: String? = null,
        subcategoryId: String? = null,
    ): Resource<List<ProductDataItemEntity?>?> {
        return homeRepository.getProducts(categoryId, subcategoryId)

    }
}