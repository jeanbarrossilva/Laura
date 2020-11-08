package com.jeanbarrossilva.laura.ui.component

import android.content.Context
import android.util.AttributeSet
import com.jeanbarrossilva.laura.R
import com.jeanbarrossilva.laura.ext.BalanceInfluenceX.formattedAmount
import com.jeanbarrossilva.laurafoundation.data.BalanceInfluence
import com.jeanbarrossilva.laurafoundation.data.LauraTableCellConfig

class BalanceInfluenceTableLayout : LauraTableLayout {
    var influence: BalanceInfluence? = null
        set(value) {
            field = value
            cells.forEachIndexed { index, cell -> cell.configWith(getConfigs()[index]) }
        }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    override fun getConfigs(): List<LauraTableCellConfig> {
        return listOf(
            LauraTableCellConfig(
                title = if (influence?.decreases == true) R.string.cost else R.string.amount,
                representation = influence?.formattedAmount
            )
        )
    }
}