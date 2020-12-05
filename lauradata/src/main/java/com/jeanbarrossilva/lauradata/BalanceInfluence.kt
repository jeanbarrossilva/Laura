package com.jeanbarrossilva.lauradata

import com.jeanbarrossilva.lauradata.converter.BalanceInfluenceTypeConverter
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class BalanceInfluence(
    @Id var id: Long = 0L,
    @Convert(converter = BalanceInfluenceTypeConverter::class, dbType = Int::class) val type: BalanceInfluenceType,
    var name: String,
    var amount: Float
)