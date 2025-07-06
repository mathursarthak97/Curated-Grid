package com.example.staggeredgrid.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.staggeredgrid.domain.model.SubWidgetItem
import com.example.staggeredgrid.domain.model.WidgetItem
import com.example.staggeredgrid.domain.repository.Repository
import com.example.staggeredgrid.presentation.utils.DataFeeder
import com.example.staggeredgrid.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WidgetListViewModel constructor(
//	private val repository: Repository,
	application: Application
) : AndroidViewModel(application) {

	private val _uiState =
		MutableStateFlow<Resource<List<SubWidgetItem>>>(Resource.Loading())
	val uiState = _uiState.asStateFlow()

	fun getWidgets() {
		/*
		viewModelScope.launch {
			repository.getWidgets().collect {
				_uiState.value = it
			}
		}*/
	}

	fun getData(): List<WidgetItem> {
		val dataFeeder = DataFeeder()
		return dataFeeder.getWidgets()
	}
}