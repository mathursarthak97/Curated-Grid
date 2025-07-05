package com.example.staggeredgrid.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SubWidgetItemDto(
	@SerializedName("type")
	val type: String,
	@SerializedName("title")
	val title: String,
	@SerializedName("image_url")
	val imageUrl: String,
	@SerializedName("food_type")
	val foodType: String
) : Parcelable {
	companion object {
//		fun toDomain(itemDto: SubWidgetItemDto): SubWidgetItem {
//
//		}
//
//		fun fromDomain(item: SubWidgetItem): SubWidgetItemDto {
//
//		}
	}
}