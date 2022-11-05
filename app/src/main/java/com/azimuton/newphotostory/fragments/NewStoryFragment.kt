package com.azimuton.newphotostory.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.azimuton.newphotostory.MAIN
import com.azimuton.newphotostory.R
import com.azimuton.newphotostory.databinding.FragmentMainStoryBinding
import com.azimuton.newphotostory.databinding.FragmentNewStoryBinding
import com.bumptech.glide.Glide


class NewStoryFragment : Fragment() {
    private lateinit var binding: FragmentNewStoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewStoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Glide.with(requireContext())
            .asGif()
            .load(R.drawable.backnote)
            .into(binding.ivBackNewStory)

        binding.llAddToStory.setOnClickListener {
            MAIN.navController.navigate(R.id.action_newStoryFragment_to_newPhotoFragment)
        }
        binding.ivBackNewStory.setOnClickListener {
            MAIN.navController.navigate(R.id.action_newStoryFragment_to_mainStoryFragment)
        }

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                MAIN.navController.navigate(R.id.action_newStoryFragment_to_mainStoryFragment)
            }
        }
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, callback)
    }


}