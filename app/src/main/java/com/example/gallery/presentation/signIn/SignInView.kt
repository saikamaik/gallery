package com.example.gallery.presentation.signIn

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface SignInView: MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun navigateToHomeFragment()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showToast(id: Int)

}