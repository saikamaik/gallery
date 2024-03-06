package com.example.gallery.presentation.photoInfoFragment

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface PhotoInfoView: MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun initView(id: Int)

}