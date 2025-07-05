package com.example.staggeredgrid.data.service

import com.example.staggeredgrid.data.model.SubWidgetItemDto
import retrofit2.http.GET

interface ApiService {
	@GET("/widgets")
	suspend fun getWidgets(): List<SubWidgetItemDto>
}