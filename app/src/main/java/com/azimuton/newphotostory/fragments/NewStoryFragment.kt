package com.azimuton.newphotostory.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.azimuton.newphotostory.R
import com.azimuton.newphotostory.databinding.FragmentMainStoryBinding
import com.azimuton.newphotostory.databinding.FragmentNewStoryBinding


class NewStoryFragment : Fragment() {
    private lateinit var binding: FragmentNewStoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNewStoryBinding.inflate(inflater, container, false)
        return binding.root
    }


}