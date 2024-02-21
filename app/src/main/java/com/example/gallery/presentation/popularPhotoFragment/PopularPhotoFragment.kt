package com.example.gallery.presentation.popularPhotoFragment

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery.App
import com.example.gallery.databinding.FragmentPopularBinding
import com.example.gallery.db.entity.PhotoDto
import com.example.gallery.presentation.homeFragment.HomeFragmentDirections
import com.example.gallery.recyclerview.RecyclerViewAdapter
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class PopularPhotoFragment : MvpAppCompatFragment(), PopularPhotoView {

    private lateinit var binding: FragmentPopularBinding
    private var recyclerViewAdapter: RecyclerViewAdapter = RecyclerViewAdapter()

    @InjectPresenter
    lateinit var presenter: PopularPhotoPresenter

    @ProvidePresenter
    fun providePresenter(): PopularPhotoPresenter = App.appComponent.providePopularPhotoPresenter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPopularBinding.inflate(layoutInflater)
        return binding.root
    }

    private var photoList: List<String> = arrayListOf(
        "https://w7.pngwing.com/pngs/194/110/png-transparent-one-number-1-digit.png",
        "https://w7.pngwing.com/pngs/33/762/png-transparent-two-number-2-digit.png",
        "https://w7.pngwing.com/pngs/976/34/png-transparent-five-number-5-digit.png",
        "https://w7.pngwing.com/pngs/37/325/png-transparent-seven-number-7-digit.png",
        "https://w7.pngwing.com/pngs/844/849/png-transparent-nine-number-9-digit.png"
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkForPhotos()
        recyclerViewAdapter.setPhotosData(presenter.getPopularPhotos())

    }

    private fun checkForPhotos() {
        if (presenter.getPopularPhotos().isEmpty()) {
            for (photo in photoList)
                presenter.insertPhoto(
                    PhotoDto(0, photo, "popular")
                )
        }
    }

    override fun initRecyclerView() {

        recyclerViewAdapter.onItemClick = {
            navigateToPhotoInfo(it)
        }

        val recyclerView: RecyclerView = binding.recyclerViewPopular
        val progressBar: ProgressBar = binding.progressbar
        progressBar.isVisible = false

        var linearLayoutManager = GridLayoutManager(this.context, 2)
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            linearLayoutManager = GridLayoutManager(this.context, 4)
        }

        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = recyclerViewAdapter

    }

    private fun navigateToPhotoInfo(photoDto: PhotoDto) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToPhotoInfoFragment(
                photoDto.photoId
            )
        )
    }

}