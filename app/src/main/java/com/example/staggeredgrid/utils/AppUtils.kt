package com.example.staggeredgrid.utils

import android.content.res.Resources

object AppUtils {
	@JvmStatic
	fun getScreenWidth(): Int {
		val displayMetrics = Resources.getSystem().displayMetrics
		return displayMetrics.widthPixels
	}
}