package com.example.staggeredgrid.domain.model

import androidx.annotation.StringDef

@Retention(AnnotationRetention.SOURCE)
@StringDef(
	ORIENTATION_HORIZONTAL,
	ORIENTATION_VERTICAL
)
annotation class Orientation

const val ORIENTATION_HORIZONTAL = "HORIZONTAL"
const val ORIENTATION_VERTICAL = "VERTICAL"

data class WidgetItem(
	val type: String,
	val data: List<SubWidgetItem>,
	@Orientation
	val orientation: String,
	private val _spanCount: Int?
) {
	val spanCount: Int
		get() = _spanCount ?: 1
}