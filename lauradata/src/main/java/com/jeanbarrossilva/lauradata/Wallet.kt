package com.jeanbarrossilva.lauradata

import com.jeanbarrossilva.lauradata.converter.CurrencyConverter
import com.jeanbarrossilva.lauradata.extension.CurrencyX.localCurrency
import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import java.util.*

@Entity
data class Wallet(
	@Id var id: Long = 0L,
	var name: String,
	@Convert(converter = CurrencyConverter::class, dbType = String::class) var currency: Currency,
	var balance: Float,
	var limit: Float
) {
	val influences = mutableListOf<BalanceInfluence>()

	companion object {
		val main = Wallet(name = "Main", currency = localCurrency(), balance = 0f, limit = 0f)
	}
}