package com.jeanbarrossilva.lauradata.extension

import android.os.Build
import android.view.View
import android.view.WindowInsets.Type.ime
import android.view.inputmethod.InputMethodManager.HIDE_IMPLICIT_ONLY
import android.view.inputmethod.InputMethodManager.SHOW_FORCED
import com.jeanbarrossilva.lauradata.extension.ContextX.inputMethodManager

object ViewX {
	fun View.showSoftInput() {
		if (Build.VERSION.SDK_INT >= 30) windowInsetsController?.show(ime()) else context.inputMethodManager.showSoftInput(this, SHOW_FORCED)
	}


	fun View.hideSoftInput() {
		if (Build.VERSION.SDK_INT >= 30)
			windowInsetsController?.hide(ime())
		else
			context.inputMethodManager.hideSoftInputFromWindow(windowToken, HIDE_IMPLICIT_ONLY)
	}
}