package com.example.staggeredgrid.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.staggeredgrid.databinding.SubWidgetItem1LayoutBinding
import com.example.staggeredgrid.databinding.SubWidgetItem2LayoutBinding
import com.example.staggeredgrid.databinding.WidgetItemLayoutBinding
import com.example.staggeredgrid.domain.model.SubWidgetItem
import com.example.staggeredgrid.domain.model.WidgetItem
import com.example.staggeredgrid.presentation.components.SubWidgetItemCard1
import com.example.staggeredgrid.presentation.components.SubWidgetItemCard2
import com.example.staggeredgrid.presentation.components.WidgetItemCard
import com.example.staggeredgrid.utils.AppUtils

const val ITEM_VIEW_TYPE_WIDGET = 0
const val ITEM_VIEW_TYPE_SUB_WIDGET_ITEM_1 = 1
const val ITEM_VIEW_TYPE_SUB_WIDGET_ITEM_2 = 2

const val ITEM_TYPE_SUB_WIDGET_1 = "sub_widget_item_1"
const val ITEM_TYPE_SUB_WIDGET_2 = "sub_widget_item_2"

class WidgetAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

	private val dataset = mutableListOf<AdapterItem>()

	private val screenWidth by lazy {
		AppUtils.getScreenWidth()
	}

	override fun onCreateViewHolder(
		parent: ViewGroup,
		viewType: Int
	): RecyclerView.ViewHolder {
		val inflater = LayoutInflater.from(parent.context)
		return when (viewType) {
			ITEM_VIEW_TYPE_WIDGET -> {
				val binding = WidgetItemLayoutBinding.inflate(inflater, parent, false)
				WidgetItemCard(binding)
			}

			ITEM_VIEW_TYPE_SUB_WIDGET_ITEM_1 -> {
				val binding = SubWidgetItem1LayoutBinding.inflate(inflater, parent, false)
				SubWidgetItemCard1(binding)
			}

			ITEM_VIEW_TYPE_SUB_WIDGET_ITEM_2 -> {
				val binding = SubWidgetItem2LayoutBinding.inflate(inflater, parent, false)
				SubWidgetItemCard2(binding)
			}

			else -> {
				// TODO an empty card implementation if required
				val binding = SubWidgetItem1LayoutBinding.inflate(inflater, parent, false)
				SubWidgetItemCard1(binding)
			}
		}
	}

	override fun onBindViewHolder(
		holder: RecyclerView.ViewHolder,
		position: Int
	) {
		val item = dataset[position]
		val data = item.data

		when (holder) {
			is WidgetItemCard -> {
				if (data is WidgetItem) {
					holder.setUI(data)
				}
			}

			is SubWidgetItemCard1 -> {
				if (data is SubWidgetItem) {
					holder.setUI(data)
				}
				adjustLayoutParams(holder, position)
			}

			is SubWidgetItemCard2 -> {
				if (data is SubWidgetItem) {
					holder.setUI(data)
				}
				adjustLayoutParams(holder, position)
			}
		}
	}

	override fun getItemCount(): Int = dataset.size

	private fun adjustLayoutParams(
		holder: RecyclerView.ViewHolder,
		position: Int
	) {
		val layoutParams = holder.itemView.layoutParams
		layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
		layoutParams.width = when (getItemViewType(position)) {
			ITEM_VIEW_TYPE_SUB_WIDGET_ITEM_2 -> (screenWidth / 3) * 2 // 2 columns
			ITEM_VIEW_TYPE_SUB_WIDGET_ITEM_1 -> screenWidth / 3 // 1 column
			else -> screenWidth
		}

		holder.itemView.layoutParams = layoutParams
	}

	fun addWidgets(widgets: List<WidgetItem>?) {
		if (widgets.isNullOrEmpty()) {
			return
		}

		val newDataset = mutableListOf<AdapterItem>()
		for (widget in widgets) {
			newDataset.add(AdapterItem(ITEM_VIEW_TYPE_WIDGET, widget))
		}

		dataset.apply {
			clear()
			addAll(newDataset)
		}

		notifyDataSetChanged()
	}

	fun addSubWidgets(subWidgets: List<SubWidgetItem>?) {
		if (subWidgets.isNullOrEmpty()) {
			return
		}

		val newDataset = mutableListOf<AdapterItem>()
		for (subWidget in subWidgets) {
			val subWidgetType = subWidget.type
			val itemViewType = if (subWidgetType.equals(ITEM_TYPE_SUB_WIDGET_1, false)) {
				ITEM_VIEW_TYPE_SUB_WIDGET_ITEM_1
			} else if (subWidgetType.equals(ITEM_TYPE_SUB_WIDGET_2, false)) {
				ITEM_VIEW_TYPE_SUB_WIDGET_ITEM_2
			} else {
				-1
			}

			if (itemViewType == -1) {
				continue
			}

			newDataset.add(AdapterItem(itemViewType, subWidget))
		}

		dataset.apply {
			clear()
			addAll(newDataset)
		}

		notifyDataSetChanged()
	}

	override fun getItemViewType(position: Int): Int = dataset[position].itemViewType
}