package com.example.gallery.presentation.popularPhotoFragment

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface PopularPhotoView: MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun initRecyclerView()

}