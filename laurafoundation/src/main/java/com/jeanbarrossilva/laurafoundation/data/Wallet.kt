package com.jeanbarrossilva.laurafoundation.data

import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "wallets")
data class Wallet(
    @PrimaryKey val uuid: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "currency") val currency: Currency,
    @ColumnInfo(name = "balance") var balance: Float
) : Parcelable {
    override fun equals(other: Any?) = other is Wallet && other.uuid == this.uuid

    override fun hashCode() = uuid.hashCode()

    companion object {
        @SuppressLint("ConstantLocale")
        val main = Wallet(
            name = "Main",
            currency = Locale.getDefault().let { defaultLocale -> Currency.getInstance(defaultLocale) },
            balance = Acquirer.salary
        )
    }
}