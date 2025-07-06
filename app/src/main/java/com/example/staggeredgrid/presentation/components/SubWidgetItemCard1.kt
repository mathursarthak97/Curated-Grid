package com.example.staggeredgrid.presentation.components

import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.staggeredgrid.R
import com.example.staggeredgrid.databinding.SubWidgetItem1LayoutBinding
import com.example.staggeredgrid.domain.model.EGG
import com.example.staggeredgrid.domain.model.NON_VEG
import com.example.staggeredgrid.domain.model.SubWidgetItem
import com.example.staggeredgrid.domain.model.VEG

class SubWidgetItemCard1(
	private val binding: SubWidgetItem1LayoutBinding
) : RecyclerView.ViewHolder(binding.root) {

	private val vegIcon by lazy {
		ContextCompat.getDrawable(itemView.context, R.drawable.veg_type_icon)
	}

	private val nonVegIcon by lazy {
		ContextCompat.getDrawable(itemView.context, R.drawable.non_veg_type_icon)
	}

	private val eggIcon by lazy {
		ContextCompat.getDrawable(itemView.context, R.drawable.egg_type_icon)
	}

	fun setUI(data: SubWidgetItem) {
		binding.apply {
			tvTitle.text = data.title
			Glide.with(ivImage.context)
				.load(data.imageUrl)
				.into(ivImage)

			val itemIcon: Drawable = when (data.foodType) {
				VEG -> vegIcon
				NON_VEG -> nonVegIcon
				EGG -> eggIcon
				else -> vegIcon
			}

			ivItemType.setImageDrawable(itemIcon)
		}
	}
}