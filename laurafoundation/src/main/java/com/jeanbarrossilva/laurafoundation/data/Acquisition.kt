package com.jeanbarrossilva.laurafoundation.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jeanbarrossilva.laurafoundation.ext.NumberX.percentOf
import kotlinx.android.parcel.Parcelize
import java.util.Currency
import java.util.UUID

@Parcelize
@Entity(tableName = "acquisitions")
data class Acquisition(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "currency") var currency: Currency,
    @ColumnInfo(name = "price") var price: Float
) : Parcelable {
    infix fun isExpensiveFor(wallet: Wallet) = price > 50 percentOf wallet.balance

    infix fun isInsaneFor(wallet: Wallet) = price > wallet.balance
}