package com.example.staggeredgrid.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.staggeredgrid.databinding.SubWidgetItem1LayoutBinding
import com.example.staggeredgrid.databinding.SubWidgetItem2LayoutBinding
import com.example.staggeredgrid.domain.model.SubWidgetItem
import com.example.staggeredgrid.presentation.components.SubWidgetItemCard1
import com.example.staggeredgrid.presentation.components.SubWidgetItemCard2

const val ITEM_VIEW_TYPE_SUB_WIDGET_ITEM_1 = 1
const val ITEM_VIEW_TYPE_SUB_WIDGET_ITEM_2 = 2
const val ITEM_TYPE_SUB_WIDGET_1 = "sub_widget_item_1"
const val ITEM_TYPE_SUB_WIDGET_2 = "sub_widget_item_2"

class WidgetAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

	private val dataset = mutableListOf<SubWidgetItem>()

	override fun onCreateViewHolder(
		parent: ViewGroup,
		viewType: Int
	): RecyclerView.ViewHolder {
		val inflater = LayoutInflater.from(parent.context)
		return when (viewType) {
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
		val data = dataset[position]
		when (holder) {
			is SubWidgetItemCard1 -> {
				holder.setUI(data)
			}

			is SubWidgetItemCard2 -> {
				holder.setUI(data)
			}
		}
	}

	override fun getItemCount(): Int = dataset.size

	fun updateItems(newDataset: List<SubWidgetItem>?) {
		if (newDataset.isNullOrEmpty()) {
			return
		}

//		val diffResult = DiffUtil.calculateDiff(
//			GenericDiffUtil(dataset, newDataset) { oldItemPosition: Int, newItemPosition: Int ->
//				return@GenericDiffUtil dataset[oldItemPosition].code == newDataset[newItemPosition].code
//			})

		dataset.apply {
			clear()
			addAll(newDataset)
//			diffResult.dispatchUpdatesTo(this@RatesAdapter)
		}

		notifyDataSetChanged()
	}

	override fun getItemViewType(position: Int): Int {
		val item = dataset[position]
		if (item.type == ITEM_TYPE_SUB_WIDGET_1) {
			return ITEM_VIEW_TYPE_SUB_WIDGET_ITEM_1
		} else if (item.type == ITEM_TYPE_SUB_WIDGET_2) {
			return ITEM_VIEW_TYPE_SUB_WIDGET_ITEM_2
		}

		return ITEM_VIEW_TYPE_SUB_WIDGET_ITEM_1
	}
}