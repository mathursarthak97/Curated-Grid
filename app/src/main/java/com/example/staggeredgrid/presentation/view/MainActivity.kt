package com.example.staggeredgrid.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.staggeredgrid.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		val widgetListFragment = WidgetListFragment.newInstance()

		if (savedInstanceState == null) {
			supportFragmentManager.beginTransaction()
				.add(binding.fragmentContainer.id, widgetListFragment, WidgetListFragment.TAG)
				.commit()
		}
	}
}