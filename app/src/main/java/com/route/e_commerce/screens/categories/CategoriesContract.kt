package com.route.e_commerce.screens.categories

import androidx.compose.runtime.State
import com.route.domin.entities.common.CategoryDataEntity
import kotlinx.coroutines.flow.SharedFlow

class CategoriesContract {
    sealed interface ViewModel {
        val state: State<UiState>
        val events: SharedFlow<Event>
        fun handleIntent(intent: Intent)
    }
    data class UiState(
        val subCategoriesState: CategoriesContract.ApiState<List<CategoryDataEntity?>?> = CategoriesContract.ApiState.Idle,

    )
    sealed interface Event {
        data class NavigateToProductScreen(val category: CategoryDataEntity) : Event

    }
    sealed interface Intent {
        data object LoadSubCategories : Intent
        data class CategoryClicked(val categoryId: String) : Intent
        data class SubCategoryClicked(val subCategory: CategoryDataEntity) : Intent
    }
    sealed interface ApiState<out T> {
        data object Idle : ApiState<Nothing>
        data object Loading : ApiState<Nothing>
        data class Success<T>(val data: T) : ApiState<T>
        data class Error(val message: String) : ApiState<Nothing>
    }
}