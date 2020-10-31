package com.jeanbarrossilva.laurafoundation.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "wallets")
data class Wallet(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "currency") val currency: Currency,
    @ColumnInfo(name = "balance") var balance: Float
) : Parcelable {
    companion object {
        @Suppress("ConstantLocale")
        val main = Wallet(
            id = 1,
            name = "Main",
            currency = Locale.getDefault().let { defaultLocale -> Currency.getInstance(defaultLocale) },
            balance = 0f
        )
    }
}