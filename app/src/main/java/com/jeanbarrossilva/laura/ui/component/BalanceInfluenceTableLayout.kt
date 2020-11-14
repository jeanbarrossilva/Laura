package com.jeanbarrossilva.laura.ui.component

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laura.ext.BalanceInfluenceX.formattedAmount
import com.jeanbarrossilva.laurafoundation.data.BalanceInfluence
import com.jeanbarrossilva.laurafoundation.data.LauraTableCellConfig
import com.jeanbarrossilva.laurafoundation.data.LauraTableCellRepresentationConfig

class BalanceInfluenceTableLayout : LauraTableLayout {
    var influence: BalanceInfluence? = null
        set(value) {
            field = value
            cells.forEachIndexed { index, cell -> cell.configWith(getConfigs()[index]) }
        }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun getConfigs(): List<LauraTableCellConfig> {
        return listOf(
            LauraTableCellConfig(
                title = R.string.BalanceInfluence_amount,
                LauraTableCellRepresentationConfig(title = influence?.formattedAmount.toString(), InputType.TYPE_CLASS_NUMBER)
            )
        )
    }
}