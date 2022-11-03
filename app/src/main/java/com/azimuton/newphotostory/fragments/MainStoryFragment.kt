package com.azimuton.newphotostory.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.azimuton.newphotostory.databinding.FragmentMainStoryBinding


class MainStoryFragment : Fragment() {

    private lateinit var binding: FragmentMainStoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainStoryBinding.inflate(inflater, container, false)
        return binding.root
    }

}