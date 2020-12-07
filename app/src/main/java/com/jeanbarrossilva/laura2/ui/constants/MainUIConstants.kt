package com.jeanbarrossilva.laura2.ui.constants

object MainUIConstants {
	const val ARG_BALANCE_INFLUENCE = "influenceId"

	const val ROUTE_WALLET_UI = "wallet"
	const val ROUTE_BALANCE_INFLUENCE = "balanceInfluence/{$ARG_BALANCE_INFLUENCE}"
	const val ROUTE_BALANCE_INFLUENCE_COMPOSER_UI = "balanceInfluenceComposer"
	const val HOME_ROUTE = ROUTE_WALLET_UI
}