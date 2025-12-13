package com.route.e_commerce.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.domin.base.Resource
import com.route.domin.useCase.home.GetCategoriesUseCase
import com.route.domin.useCase.home.GetProductsUseCase
import com.route.domin.useCase.home.GetSubCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getProductsUseCase: GetProductsUseCase,


) : ViewModel(),HomeContract.ViewModel {
    private val _state: MutableState<HomeContract.UiState> = mutableStateOf(HomeContract.UiState())
    private val _events = MutableSharedFlow<HomeContract.Event>()

    override val state: State<HomeContract.UiState>
        get() = _state
    override val events: SharedFlow<HomeContract.Event>
        get() = _events.asSharedFlow()

    init {
        handleIntent(HomeContract.Intent.LoadCategories)
        handleIntent(HomeContract.Intent.LoadProducts())
    }

    override fun handleIntent(intent: HomeContract.Intent) {
        when(intent){
            is HomeContract.Intent.CategoryClicked -> {
                viewModelScope.launch {
                    _events.emit(HomeContract.Event.NavigateToCategory(intent.category))
                }
            }
            HomeContract.Intent.LoadCategories -> {
                loadCategories()
            }
            is HomeContract.Intent.LoadProducts -> {
                loadProducts(intent.categoryId, intent.subcategoryId)
            }
        }
    }

    private fun loadCategories(){
        viewModelScope.launch {
            _state.value = _state.value.copy(categoriesState = HomeContract.ApiState.Loading)
            val response  = getCategoriesUseCase.invoke()
            when(response){
                is Resource.Failure -> {
                    _state.value = _state.value.copy(categoriesState = HomeContract.ApiState.Error(response.message))
                }
                is Resource.Success -> {
                    _state.value = _state.value.copy(categoriesState = HomeContract.ApiState.Success(response.data))
                }
            }
        }
    }



    private fun loadProducts(categoryId: String? = null, subcategoryId: String? = null){
        viewModelScope.launch {
            _state.value = _state.value.copy(productsState = HomeContract.ApiState.Loading)
            val response = getProductsUseCase.invoke(categoryId, subcategoryId)
            when(response){
                is Resource.Failure -> {
                    _state.value = _state.value.copy(productsState = HomeContract.ApiState.Error(response.message))
                }
                is Resource.Success -> {
                    _state.value = _state.value.copy(productsState = HomeContract.ApiState.Success(response.data))
                }
            }
        }

    }


}