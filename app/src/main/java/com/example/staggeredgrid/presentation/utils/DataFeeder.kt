package com.example.staggeredgrid.presentation.utils

import com.example.staggeredgrid.domain.model.SubWidgetItem
import com.example.staggeredgrid.domain.model.WidgetItem

class DataFeeder {
	fun getWidgets(): List<WidgetItem> {
		return mutableListOf<WidgetItem>(
			getWidgetItem1(),
			getWidgetItem2(),
			getWidgetItem1(),
			getWidgetItem1(),
			getWidgetItem2(),
			getWidgetItem1()
		)
	}

	fun getWidgetItem1(): WidgetItem {
		return WidgetItem(
			"widget",
			mutableListOf<SubWidgetItem>(
				SubWidgetItem(
					"sub_widget_item_1",
					"Title 1",
					"https://cdn.dummyjson.com/recipe-images/1.webp",
					"veg"
				),
				SubWidgetItem(
					"sub_widget_item_1",
					"Title 2",
					"https://cdn.dummyjson.com/recipe-images/2.webp",
					"non-veg"
				),
				SubWidgetItem(
					"sub_widget_item_2",
					"Title 3",
					"https://cdn.dummyjson.com/recipe-images/3.webp",
					"non-veg"
				)
			),
			"HORIZONTAL",
			2
		)
	}

	fun getWidgetItem2(): WidgetItem {
		return WidgetItem(
			"widget",
			mutableListOf<SubWidgetItem>(
				SubWidgetItem(
					"sub_widget_item_1",
					"Title 1",
					"https://cdn.dummyjson.com/recipe-images/4.webp",
					"egg"
				),
				SubWidgetItem(
					"sub_widget_item_1",
					"Title 2",
					"https://cdn.dummyjson.com/recipe-images/5.webp",
					"veg"
				),
				SubWidgetItem(
					"sub_widget_item_1",
					"Title 3",
					"https://cdn.dummyjson.com/recipe-images/6.webp",
					"non-veg"
				)
			),
			"HORIZONTAL",
			1
		)
	}
}