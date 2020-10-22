package com.jeanbarrossilva.laurafoundation.data

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import java.util.*

data class Wallet(var name: MutableLiveData<String>, val currency: MutableLiveData<Currency>, val balance: MutableLiveData<Double>) {
    companion object {
        @SuppressLint("ConstantLocale")
        val main = Wallet(
            name = MutableLiveData("Wallet"),
            currency = MutableLiveData(Locale.getDefault().let { Currency.getInstance(it) }),
            balance = MutableLiveData(0.0)
        )
    }
}