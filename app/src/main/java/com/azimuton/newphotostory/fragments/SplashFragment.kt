package com.azimuton.newphotostory.fragments

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.azimuton.newphotostory.MAIN
import com.azimuton.newphotostory.R
import com.azimuton.newphotostory.databinding.FragmentSplashBinding
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class SplashFragment : Fragment(), CoroutineScope {
    private lateinit var binding: FragmentSplashBinding
    private val job = Job()
    override val coroutineContext:CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        CoroutineScope(Dispatchers.Main).launch {
            binding.progressBar.max = 1000
            val value = 1000
            ObjectAnimator.ofInt(binding.progressBar, "progress", value).setDuration(3000).start()
            delay(3000)
            MAIN.navController.navigate(R.id.mainStoryFragment)
        }


    }


}