package com.example.gallery.presentation.newPhotoFragment

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface NewPhotoView: MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun initRecyclerView()

}