package com.route.e_commerce.screens.home

import androidx.compose.runtime.State
import com.route.domin.entities.common.CategoryDataEntity
import com.route.domin.entities.products.response.ProductDataItemEntity
import kotlinx.coroutines.flow.SharedFlow

class HomeContract {
    sealed interface ViewModel {
        val state: State<UiState>
        val events: SharedFlow<Event>
        fun handleIntent(intent: Intent)
    }

    data class UiState(
        val categoriesState: ApiState<List<CategoryDataEntity?>?> = ApiState.Idle,
        val productsState: ApiState<List<ProductDataItemEntity?>?> = ApiState.Idle
    )

    sealed interface ApiState<out T> {
        data object Idle : ApiState<Nothing>
        data object Loading : ApiState<Nothing>
        data class Success<T>(val data: T) : ApiState<T>
        data class Error(val message: String) : ApiState<Nothing>
    }

    sealed interface Event {
        //navigate to category screen
        data class NavigateToCategory(val category: CategoryDataEntity) : Event

    }

    sealed interface Intent {
        data object LoadCategories : Intent
        data class LoadProducts(val categoryId: String? = null, val subcategoryId: String? = null) : Intent
        data class CategoryClicked(val category: CategoryDataEntity) : Intent

    }
}