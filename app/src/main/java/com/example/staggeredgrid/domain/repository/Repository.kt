package com.example.staggeredgrid.domain.repository

import com.example.staggeredgrid.utils.Resource
import com.example.staggeredgrid.domain.model.SubWidgetItem
import kotlinx.coroutines.flow.Flow

interface Repository {
	suspend fun getWidgets(): Flow<Resource<List<SubWidgetItem>>>
}