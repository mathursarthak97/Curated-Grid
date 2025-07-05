package com.example.staggeredgrid.presentation.utils

import com.example.staggeredgrid.domain.model.SubWidgetItem

class DataFeeder {
	fun getWidgets(): List<SubWidgetItem> {
		return mutableListOf<SubWidgetItem>(
			SubWidgetItem(
				"sub_widget_item_1",
				"Title 1",
				"https://cdn.dummyjson.com/recipe-images/1.webp",
				""
			),
			SubWidgetItem(
				"sub_widget_item_2",
				"Title 2",
				"https://cdn.dummyjson.com/recipe-images/1.webp",
				""
			),
			SubWidgetItem(
				"sub_widget_item_1",
				"Title 3",
				"https://cdn.dummyjson.com/recipe-images/1.webp",
				""
			),
			SubWidgetItem(
				"sub_widget_item_1",
				"Title 4 ",
				"https://cdn.dummyjson.com/recipe-images/1.webp",
				""
			),
			SubWidgetItem(
				"sub_widget_item_1",
				"Title 5",
				"https://cdn.dummyjson.com/recipe-images/1.webp",
				""
			),
			SubWidgetItem(
				"sub_widget_item_1",
				"Title 6",
				"https://cdn.dummyjson.com/recipe-images/1.webp",
				""
			)
		)
	}
}