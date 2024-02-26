package com.example.gallery.presentation.homeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.gallery.databinding.FragmentHomeBinding
import com.example.gallery.presentation.TabsPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import moxy.MvpAppCompatFragment
import javax.inject.Inject

class HomeFragment: MvpAppCompatFragment(), HomeView {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var tabsPagerAdapter: TabsPagerAdapter

    @Inject
    lateinit var presenter: HomePresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initTabsPager()
        binding.loadingPlaceholder.isVisible = false

    }

    private fun initTabsPager() {

        tabsPagerAdapter = TabsPagerAdapter(this)

        val tabTitle = arrayOf("New", "Popular")

        binding.tabsViewpager.adapter = tabsPagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.tabsViewpager) { tab, position ->
            tab.text = tabTitle[position]
        }.attach()

    }

}