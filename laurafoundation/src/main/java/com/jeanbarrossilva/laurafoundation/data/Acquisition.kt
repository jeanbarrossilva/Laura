package com.jeanbarrossilva.laurafoundation.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.Currency
import java.util.UUID

@Parcelize
@Entity(tableName = "acquisitions")
data class Acquisition(
    @PrimaryKey val uuid: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "currency") var currency: Currency,
    @ColumnInfo(name = "price") var price: Float
) : Parcelable