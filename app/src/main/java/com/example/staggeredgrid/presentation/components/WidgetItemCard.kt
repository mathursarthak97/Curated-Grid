package com.example.staggeredgrid.presentation.components

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.staggeredgrid.databinding.WidgetItemLayoutBinding
import com.example.staggeredgrid.domain.model.ORIENTATION_VERTICAL
import com.example.staggeredgrid.domain.model.WidgetItem
import com.example.staggeredgrid.presentation.adapter.ITEM_VIEW_TYPE_SUB_WIDGET_ITEM_1
import com.example.staggeredgrid.presentation.adapter.ITEM_VIEW_TYPE_SUB_WIDGET_ITEM_2
import com.example.staggeredgrid.presentation.adapter.WidgetAdapter
import com.example.staggeredgrid.presentation.utils.NoSpaceItemDecoration


class WidgetItemCard(
	private val binding: WidgetItemLayoutBinding
) : RecyclerView.ViewHolder(binding.root) {

	private val itemsAdapter by lazy {
		WidgetAdapter()
	}

	fun setUI(widgetItem: WidgetItem) {
		binding.rvItems.apply {
			val itemsOrientation = widgetItem.orientation
			val spanCount = widgetItem.spanCount

			val orientation = if (itemsOrientation == ORIENTATION_VERTICAL) {
				GridLayoutManager.VERTICAL
			} else {
				GridLayoutManager.HORIZONTAL
			}

			val gridLayoutManager = GridLayoutManager(
				context, spanCount, orientation, false
			).also {
				it.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
					override fun getSpanSize(position: Int): Int {
						return when (itemsAdapter.getItemViewType(position)) {
							ITEM_VIEW_TYPE_SUB_WIDGET_ITEM_2 -> 2
							ITEM_VIEW_TYPE_SUB_WIDGET_ITEM_1 -> 1
							else -> 1
						}
					}
				}
			}

			layoutManager = gridLayoutManager
			setHasFixedSize(true)
			addItemDecoration(NoSpaceItemDecoration())
			adapter = itemsAdapter.also {
				it.addSubWidgets(widgetItem.data)
			}
		}
	}
}