package com.example.gallery.presentation.signUp

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface SignUpView: MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun navigateToHomeFragment()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun navigateUp()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun navigateToSignInFragment()

}