package com.example.staggeredgrid.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.staggeredgrid.databinding.FragmentWidgetListBinding
import com.example.staggeredgrid.presentation.adapter.ITEM_VIEW_TYPE_SUB_WIDGET_ITEM_1
import com.example.staggeredgrid.presentation.adapter.ITEM_VIEW_TYPE_SUB_WIDGET_ITEM_2
import com.example.staggeredgrid.presentation.adapter.WidgetAdapter
import com.example.staggeredgrid.presentation.utils.NoSpaceItemDecoration
import com.example.staggeredgrid.presentation.viewmodel.WidgetListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WidgetListFragment : Fragment() {

	private lateinit var binding: FragmentWidgetListBinding
	private val widgetListViewModel: WidgetListViewModel by viewModels()

	private val widgetAdapter by lazy {
		WidgetAdapter()
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
	}

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		binding = FragmentWidgetListBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		setUI()
	}

	private fun setUI() {
		binding.rvWidgets.apply {

			val gridLayoutManager = GridLayoutManager(context, 3).also {
				it.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
					override fun getSpanSize(position: Int): Int {
						return when (widgetAdapter.getItemViewType(position)) {
							ITEM_VIEW_TYPE_SUB_WIDGET_ITEM_2 -> 2  // spans 2 columns
							ITEM_VIEW_TYPE_SUB_WIDGET_ITEM_1 -> 1  // spans 1 column
							else -> 1
						}
					}
				}
			}

			layoutManager = gridLayoutManager
			addItemDecoration(NoSpaceItemDecoration())
			adapter = widgetAdapter.also {
				it.updateItems(widgetListViewModel.getData())
			}
		}
	}

	companion object {
		@JvmStatic
		fun newInstance() = WidgetListFragment()
	}
}