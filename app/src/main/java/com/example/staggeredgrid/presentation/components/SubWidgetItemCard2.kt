package com.example.staggeredgrid.presentation.components

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.staggeredgrid.databinding.SubWidgetItem2LayoutBinding
import com.example.staggeredgrid.domain.model.SubWidgetItem

class SubWidgetItemCard2(
	private val binding: SubWidgetItem2LayoutBinding
) : RecyclerView.ViewHolder(binding.root) {

	fun setUI(data: SubWidgetItem) {
		binding.apply {
			tvTitle.text = data.title
			Glide.with(ivImage.context)
				.load(data.imageUrl)
				.into(ivImage)
		}
	}
}