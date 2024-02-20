package com.example.gallery.presentation.newPhotoFragment

import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class NewPhotoPresenter: MvpPresenter<NewPhotoView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.initRecyclerView()
    }

}