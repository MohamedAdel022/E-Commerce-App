package com.route.e_commerce.screens.categories

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.domin.base.Resource
import com.route.domin.entities.common.CategoryDataEntity
import com.route.domin.useCase.home.GetSubCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val getSubCategoriesUseCase: GetSubCategoriesUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel(), CategoriesContract.ViewModel {
    private val _selectedCategoryId = mutableStateOf(
        savedStateHandle.get<String>("selectedId")
    )

    var selectedCategoryId: String?
        get() = _selectedCategoryId.value
        private set(value) {
            _selectedCategoryId.value = value
            savedStateHandle["selectedId"] = value
        }
    private val _state: MutableState<CategoriesContract.UiState> =
        mutableStateOf(CategoriesContract.UiState())
    private val _events = MutableSharedFlow<CategoriesContract.Event>()
    override val state: State<CategoriesContract.UiState>
        get() = _state
    override val events: SharedFlow<CategoriesContract.Event>
        get() = _events
    private var initialSelectionHandled: Boolean
        get() = savedStateHandle["initialSelectionHandled"] ?: false
        set(value) {
            savedStateHandle["initialSelectionHandled"] = value
        }

    init {
        selectedCategoryId?.let {
            loadSubCategories(it)
        }
    }

    override fun handleIntent(intent: CategoriesContract.Intent) {
        when (intent) {
            CategoriesContract.Intent.LoadSubCategories -> {
                selectedCategoryId?.let { loadSubCategories(it) }

            }

            is CategoriesContract.Intent.CategoryClicked -> {
                selectCategory(intent.categoryId)

            }

            is CategoriesContract.Intent.SubCategoryClicked -> {
                viewModelScope.launch {
                    _events.emit(
                        CategoriesContract.Event.NavigateToProductScreen(
                            intent.subCategory
                        )
                    )
                }
            }
        }
    }

    private fun selectCategory(categoryId: String) {
        if (selectedCategoryId == categoryId) return

        selectedCategoryId = categoryId
        loadSubCategories(categoryId)
    }

    fun onCategoriesLoaded(categories: List<CategoryDataEntity>) {
        if (initialSelectionHandled) return

        if (selectedCategoryId == null && categories.isNotEmpty()) {
            val firstId = categories.first().id
            if (firstId != null) {
                selectedCategoryId = firstId
                loadSubCategories(firstId)
            }
        }

        initialSelectionHandled = true
    }


    private fun loadSubCategories(categoryId: String) {
        viewModelScope.launch {
            _state.value =
                _state.value.copy(subCategoriesState = CategoriesContract.ApiState.Loading)
            val response = getSubCategoriesUseCase.invoke(categoryId)
            when (response) {
                is Resource.Failure -> {
                    _state.value = _state.value.copy(
                        subCategoriesState = CategoriesContract.ApiState.Error(response.message)
                    )
                }

                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        subCategoriesState = CategoriesContract.ApiState.Success(response.data)
                    )
                }
            }
        }
    }

}