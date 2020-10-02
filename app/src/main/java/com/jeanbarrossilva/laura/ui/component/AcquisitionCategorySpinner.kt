package com.jeanbarrossilva.laura.ui.component

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.ContextThemeWrapper
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatSpinner
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laurafoundation.data.AcquisitionCategory
import kotlin.reflect.full.createInstance

class AcquisitionCategorySpinner @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : AppCompatSpinner(ContextThemeWrapper(context, R.style.LauraSpinner), attrs, defStyleAttr) {
    private val categories = AcquisitionCategory::class.sealedSubclasses.map { it.objectInstance ?: it.createInstance() }
    private val categoryNames = categories.map { category -> context.getString(category.name) }

    var category = categories.first()
        set(value) = setSelection(categories.indexOf(value), true)

    init {
        adapter = ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, categoryNames)

        onItemSelectedListener = object: OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                category = categories[position]
                Log.d("AcquisitionCategorySpinner", "Selected AcquisitionCategory: ${category.name}.")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }
}