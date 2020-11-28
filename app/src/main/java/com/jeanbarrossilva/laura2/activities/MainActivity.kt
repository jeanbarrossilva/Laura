package com.jeanbarrossilva.laura2.activities

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.platform.setContent
import com.jeanbarrossilva.laura2.LauraApplication
import com.jeanbarrossilva.laura2.ui.MainUI
import com.jeanbarrossilva.lauradata.Wallet
import com.jeanbarrossilva.lauradata.extension.AppCompatActivityX.onFirstLaunch

@ExperimentalMaterialApi
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window?.run {
            statusBarColor = Color.BLACK
            navigationBarColor = Color.BLACK
        }

        onFirstLaunch { LauraApplication.database.walletDao().add(Wallet.main) }
        setContent { MainUI() }
    }
}