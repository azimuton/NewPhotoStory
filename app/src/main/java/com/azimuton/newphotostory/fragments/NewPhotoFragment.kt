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
import com.azimuton.newphotostory.databinding.FragmentNewPhotoBinding

class NewPhotoFragment : Fragment() {
    private lateinit var binding: FragmentNewPhotoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewPhotoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                MAIN.navController.navigate(R.id.action_newPhotoFragment_to_newStoryFragment)
            }
        }
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, callback)
    }

}

