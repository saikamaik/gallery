package com.example.gallery.presentation.popularPhotoFragment

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery.databinding.FragmentPopularBinding
import com.example.gallery.recyclerview.RecyclerViewAdapter
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class PopularPhotoFragment : MvpAppCompatFragment(), PopularPhotoView {

    private lateinit var binding: FragmentPopularBinding
    private var recyclerViewAdapter: RecyclerViewAdapter = RecyclerViewAdapter()

    @InjectPresenter
    lateinit var presenter: PopularPhotoPresenter

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

        recyclerViewAdapter.setPhotosData(photoList)

    }

    override fun initRecyclerView() {

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

}