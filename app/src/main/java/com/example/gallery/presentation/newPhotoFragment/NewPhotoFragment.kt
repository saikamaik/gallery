package com.example.gallery.presentation.newPhotoFragment

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery.App
import com.example.gallery.databinding.FragmentNewBinding
import com.example.gallery.recyclerview.RecyclerViewAdapter
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class NewPhotoFragment: MvpAppCompatFragment(), NewPhotoView {

    private lateinit var binding: FragmentNewBinding
    private var recyclerViewAdapter: RecyclerViewAdapter = RecyclerViewAdapter()

    @InjectPresenter
    lateinit var presenter: NewPhotoPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewBinding.inflate(layoutInflater)
        return binding.root
    }

    private var photoList: List<String> = arrayListOf(
        "https://w7.pngwing.com/pngs/194/110/png-transparent-one-number-1-digit.png",
        "https://w7.pngwing.com/pngs/33/762/png-transparent-two-number-2-digit.png",
        "https://w7.pngwing.com/pngs/834/263/png-transparent-number-numerical-digit-three-miscellaneous-3d-computer-graphics-text.png",
        "https://w7.pngwing.com/pngs/676/18/png-transparent-four-number-4-digit.png",
        "https://w7.pngwing.com/pngs/976/34/png-transparent-five-number-5-digit.png",
        "https://w7.pngwing.com/pngs/855/831/png-transparent-six-number-6-digit.png",
        "https://w7.pngwing.com/pngs/37/325/png-transparent-seven-number-7-digit.png",
        "https://w7.pngwing.com/pngs/69/809/png-transparent-eight-number-8-digit.png",
        "https://w7.pngwing.com/pngs/844/849/png-transparent-nine-number-9-digit.png"
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewAdapter.setPhotosData(photoList)

    }

    override fun initRecyclerView() {

        val recyclerView: RecyclerView = binding.recyclerViewNew
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