package com.route.domin.useCase.home

import com.route.domin.base.Resource
import com.route.domin.entities.category.response.CategoriesResponseEntity
import com.route.domin.entities.common.CategoryDataEntity
import com.route.domin.repository.home.HomeRepository
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
   suspend fun invoke(): Resource<List<CategoryDataEntity?>?> {
       return homeRepository.getCategories()
    }

}