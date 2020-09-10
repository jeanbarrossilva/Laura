package com.jeanbarrossilva.lauraui.kit

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import android.widget.TextView
import androidx.preference.DialogPreference
import androidx.preference.PreferenceViewHolder
import com.jeanbarrossilva.lauraui.R

class LauraEditTextPreference(context: Context) : DialogPreference(context) {
    var field: EditText? = null

    override fun onBindViewHolder(holder: PreferenceViewHolder?) {
        holder?.itemView?.findViewById<TextView>(R.id.title)?.text = title
        field = holder?.itemView?.findViewById(R.id.field)
    }

    private fun start(attrs: AttributeSet? = null, defStyleAttr: Int = 0) {
        config()
        loadAttrs(attrs, defStyleAttr)
    }

    private fun config() {
        layoutResource = R.layout.dialog_bill_edit_text_preference
    }

    private fun loadAttrs(attrs: AttributeSet?, defStyleAttr: Int) {
        context.theme.obtainStyledAttributes(attrs, R.styleable.LauraEditTextPreference, defStyleAttr, 0).run {
            for (index in 0 until indexCount)
                getIndex(index).let { attr -> if (attr == R.styleable.LauraEditTextPreference_android_inputType) field?.inputType = attr }

            recycle()
        }
    }
}