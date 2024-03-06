package com.example.gallery.presentation.newPhotoFragment

import com.example.gallery.db.AppDao
import com.example.gallery.db.entity.PhotoDto
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class NewPhotoPresenter @Inject constructor(
    private var appDao: AppDao
): MvpPresenter<NewPhotoView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initRecyclerView()
    }

    fun checkForPhotos(photoList: List<String>) {
        if (getNewPhotos().isEmpty()) {
            for (photo in photoList)
                insertPhoto(
                    PhotoDto(0,
                        "photoName",
                        "Description",
                        null,
                        1, photo,
                        "new")
                )
        }
    }

    fun insertPhoto(photo: PhotoDto) {
            appDao.insertPhoto(photo)
    }

    fun getNewPhotos(): List<PhotoDto> {
        return appDao.getAllTypedPhotos("new")
    }

    fun navigateToPhotoInfoFragment(item: PhotoDto) {
        viewState.navigateToPhotoInfoFragment(item)
    }

}