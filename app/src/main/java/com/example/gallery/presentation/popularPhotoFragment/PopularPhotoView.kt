package com.example.gallery.presentation.popularPhotoFragment

import com.example.gallery.db.entity.PhotoDto
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface PopularPhotoView: MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun initRecyclerView()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun navigateToPhotoInfoFragment(item: PhotoDto)

}