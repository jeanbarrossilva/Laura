package com.jeanbarrossilva.lauradata.default

import android.content.Context
import com.jeanbarrossilva.lauradata.MyObjectBox
import com.jeanbarrossilva.lauradata.Wallet
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor

object ObjectBox {
	private lateinit var boxStore: BoxStore

	val walletBox: Box<Wallet> by lazy { boxStore.boxFor() }

	fun init(context: Context) {
		boxStore = MyObjectBox.builder().androidContext(context.applicationContext).build()
		if (Wallet.main !in walletBox.all) walletBox.put(Wallet.main)
	}
}