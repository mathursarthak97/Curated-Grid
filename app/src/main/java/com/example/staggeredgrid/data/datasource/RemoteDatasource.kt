package com.example.staggeredgrid.data.datasource

import com.example.staggeredgrid.domain.model.SubWidgetItem

interface RemoteDatasource {
	suspend fun getWidgets(): List<SubWidgetItem>
}