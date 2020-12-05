package com.jeanbarrossilva.lauradata.converter

import com.jeanbarrossilva.lauradata.BalanceInfluenceType
import io.objectbox.converter.PropertyConverter

class BalanceInfluenceTypeConverter : PropertyConverter<BalanceInfluenceType, Int> {
    override fun convertToEntityProperty(databaseValue: Int?) = databaseValue?.let { BalanceInfluenceType.values()[it] }

    override fun convertToDatabaseValue(entityProperty: BalanceInfluenceType?) = BalanceInfluenceType.values().indexOf(entityProperty)
}