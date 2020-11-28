package com.jeanbarrossilva.lauradata

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jeanbarrossilva.lauradata.extension.CurrencyX.localCurrency
import java.io.Serializable
import java.util.Currency

@Entity(tableName = "wallets")
data class Wallet(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "currency") val currency: Currency,
    @ColumnInfo(name = "balance") var balance: Float
) : Serializable {
    operator fun plus(influence: BalanceInfluence) {
        balance = if (influence.decreases) balance - influence.amount else balance + influence.amount
    }

    operator fun minus(influence: BalanceInfluence) {
        balance = if (influence.decreases) balance + influence.amount else balance - influence.amount
    }

    companion object {
        val main = Wallet(id = 1, name = "Main", currency = localCurrency(), balance = 0f)
    }
}