package com.jeanbarrossilva.laurafoundation.data

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.jeanbarrossilva.laurafoundation.R
import com.jeanbarrossilva.laurafoundation.ext.NumberX.percentOf
import java.util.Currency

@Entity(tableName = "influences")
open class BalanceInfluence(
    @PrimaryKey(autoGenerate = true) open val id: Long = 0L,
    @ColumnInfo(name = "wallet") open var walletId: String,
    @ColumnInfo(name = "icon") @DrawableRes open var icon: Int,
    @ColumnInfo(name = "name") open var name: String,
    @ColumnInfo(name = "currency") open var currency: Currency,
    @ColumnInfo(name = "amount") open var amount: Float,
    @ColumnInfo(name = "decreases") val decreases: Boolean
) {
    @Entity
    data class Acquisition(
        @Ignore override val id: Long = 0L,
        @Ignore override var walletId: String,
        @Ignore @DrawableRes override var icon: Int = R.drawable.ic_bookmark,
        @Ignore override var name: String,
        @Ignore override var currency: Currency,
        @Ignore override var amount: Float
    ) : BalanceInfluence(id, walletId, icon, name, currency, amount, decreases = true)

    @Entity
    data class Rise(
        @Ignore override val id: Long = 0L,
        @Ignore private val context: Context,
        @Ignore override var walletId: String,
        @Ignore override var currency: Currency,
        @Ignore override var amount: Float
    ) : BalanceInfluence(id, walletId, icon = R.drawable.ic_attach_money, name = context.getString(R.string.rise), currency, amount, decreases = false)

    infix fun isExpensiveFor(wallet: Wallet) = amount > 50 percentOf wallet.balance

    infix fun isInsaneFor(wallet: Wallet) = amount > wallet.balance
}