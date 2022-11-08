package com.azimuton.newphotostory.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.azimuton.domain.models.Photo
import com.azimuton.domain.usecase.GetAllUseCase
import com.azimuton.newphotostory.MAIN
import com.azimuton.newphotostory.R
import com.azimuton.newphotostory.adapters.NewStoryAdapter
import com.azimuton.newphotostory.databinding.FragmentNewStoryBinding
import com.azimuton.newphotostory.viewmodels.NewStoryViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class NewStoryFragment : Fragment(), NewStoryAdapter.ViewHolder.ItemCallback {
    private lateinit var binding: FragmentNewStoryBinding
    private lateinit var photoList: ArrayList<Photo>
    private lateinit var adapterphoto : NewStoryAdapter
    @Inject
    lateinit var provideGetAllUseCase : GetAllUseCase
    //private lateinit var getAllViewModel: NewStoryViewModel
    private lateinit var deleteViewModel: NewStoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewStoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        deleteViewModel = ViewModelProvider(requireActivity())[NewStoryViewModel::class.java]
        //getAllViewModel = ViewModelProvider(requireActivity())[NewStoryViewModel::class.java]
        Glide.with(requireContext())
            .asGif()
            .load(R.drawable.backnote)
            .into(binding.ivBackNewStory)

        photoList = ArrayList()
        getData()
        adapterphoto = NewStoryAdapter(requireContext(), photoList, this)
        binding.rvStory.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvStory.adapter = adapterphoto

        binding.llAddToStory.setOnClickListener {
            MAIN.navController.navigate(R.id.action_newStoryFragment_to_newPhotoFragment)
        }

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
    private fun getData() {
            val fromDb: List<Photo> = provideGetAllUseCase.photoExecute()
            photoList.clear()
            photoList.addAll(fromDb)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun deleteItem(index: Int) {
        val addDialog = AlertDialog.Builder(requireContext())
        addDialog
            .setMessage("Are you want to delete photo?")
            .setPositiveButton("Ok") { dialog, _ ->
                val photo = photoList[index]
                deleteViewModel.deletePhoto(photo)
                getData()
                adapterphoto.notifyDataSetChanged()
                Toast.makeText(requireContext(), "Photo is deleted!", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }

    override fun onSelected(index: Int) {
        val photo : Photo = photoList[index]
        binding.ivStoryBigPhoto.setImageURI(photo.dbphotoimage.toUri())
        binding.tvDescPhotoNewStory.text = photo.dbphotocontent
    }
}