package com.azimuton.newphotostory.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.core.net.toUri
import androidx.recyclerview.widget.LinearLayoutManager
import com.azimuton.domain.models.Photo
import com.azimuton.domain.usecase.DeleteUseCase
import com.azimuton.domain.usecase.GetAllUseCase
import com.azimuton.newphotostory.MAIN
import com.azimuton.newphotostory.R
import com.azimuton.newphotostory.adapters.NewStoryAdapter
import com.azimuton.newphotostory.databinding.FragmentMainStoryBinding
import com.azimuton.newphotostory.databinding.FragmentNewStoryBinding
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



class NewStoryFragment : Fragment(), NewStoryAdapter.ViewHolder.ItemCallback {
    private lateinit var binding: FragmentNewStoryBinding
    lateinit var photoList: ArrayList<Photo>
    lateinit var adapterphoto : NewStoryAdapter
    lateinit var getAllUseCase : GetAllUseCase
    lateinit var deleteUseCase : DeleteUseCase

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

        photoList = ArrayList<Photo>()
        //desertiDatabase = context?.let { AppDatabase.getDatabase(it) }!!
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
//        CoroutineScope(Dispatchers.IO).launch {
            val fromDb: List<Photo> = getAllUseCase.photoExecute()
            photoList.clear()
            photoList.addAll(fromDb)
        //}

    }

    override fun deleteItem(index: Int) {
        val addDialog = AlertDialog.Builder(requireContext())
        addDialog
            .setMessage("Are you want to delete photo?")
            .setPositiveButton("Ok") { dialog, _ ->
                val photo = photoList[index]
//                CoroutineScope(Dispatchers.IO).launch {
                    deleteUseCase.photoExecute(photo)
                //}
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