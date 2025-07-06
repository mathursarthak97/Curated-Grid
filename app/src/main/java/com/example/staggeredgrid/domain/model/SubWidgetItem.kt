package com.example.staggeredgrid.domain.model

import androidx.annotation.StringDef

@Retention(AnnotationRetention.SOURCE)
@StringDef(
	VEG,
	NON_VEG,
	EGG
)
annotation class FoodType

const val VEG = "veg"
const val NON_VEG = "non-veg"
const val EGG = "egg"

data class SubWidgetItem(
	val type: String,
	val title: String,
	val imageUrl: String,
	@FoodType
	val foodType: String
)