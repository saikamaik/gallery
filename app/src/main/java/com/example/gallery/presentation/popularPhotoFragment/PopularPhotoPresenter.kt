package com.example.gallery.presentation.popularPhotoFragment

import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class PopularPhotoPresenter: MvpPresenter<PopularPhotoView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.initRecyclerView()
    }

}