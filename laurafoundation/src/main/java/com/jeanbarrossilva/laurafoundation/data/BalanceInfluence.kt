package com.jeanbarrossilva.laurafoundation.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.jeanbarrossilva.laurafoundation.R
import kotlinx.android.parcel.Parcelize
import java.time.LocalDateTime

@Parcelize
@Entity(tableName = "influences")
open class BalanceInfluence(
    @PrimaryKey(autoGenerate = true) open val id: Long = 0L,
    @ColumnInfo(name = "wallet") open var walletId: Long,
    @ColumnInfo(name = "icon") @DrawableRes open var icon: Int,
    @ColumnInfo(name = "name") open var name: String,
    @ColumnInfo(name = "amount") open var amount: Float,
    @ColumnInfo(name = "date_time") val dateTime: LocalDateTime = LocalDateTime.now(),
    @ColumnInfo(name = "decreases") val decreases: Boolean
) : Parcelable {
    @Parcelize
    @Entity
    data class Acquisition(
        @Ignore override val id: Long = 0L,
        @Ignore override var walletId: Long,
        @Ignore @DrawableRes override var icon: Int = R.drawable.ic_bookmark,
        @Ignore override var name: String,
        @Ignore override var amount: Float
    ) : BalanceInfluence(id, walletId, icon, name, amount, decreases = true)

    @Parcelize
    @Entity
    data class Rise(
        @Ignore override val id: Long = 0L,
        @Ignore override var walletId: Long,
        @Ignore override var name: String,
        @Ignore override var amount: Float
    ) : BalanceInfluence(id, walletId, icon = R.drawable.ic_attach_money, name, amount, decreases = false)
}