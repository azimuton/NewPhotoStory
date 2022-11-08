package com.azimuton.newphotostory.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.azimuton.domain.models.Photo
import com.azimuton.domain.usecase.InsertUseCase
import com.azimuton.newphotostory.MAIN
import com.azimuton.newphotostory.R
import com.azimuton.newphotostory.databinding.FragmentNewPhotoBinding
import com.azimuton.newphotostory.viewmodels.NewPhotoViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NewPhotoFragment : Fragment() {
    private lateinit var binding: FragmentNewPhotoBinding
    //@Inject
    //lateinit var provideInsertUseCase : InsertUseCase
    private lateinit var mViewModel: NewPhotoViewModel
    private val Pick_image = 1
    private var tempImageUri = "empty"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewPhotoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        mViewModel = ViewModelProvider(requireActivity())[NewPhotoViewModel::class.java]

        binding.llGalery.setOnClickListener {
            chooseImage()
        }

        binding.llSaveNewPhoto.setOnClickListener {
            if (binding.etNameOfPhoto.text.isNotEmpty() || binding.etNameOfPhoto.text.isEmpty()) {
                val title: String = binding.etNameOfPhoto.text.toString()
                val content: String = binding.etDescOfPhoto.text.toString()
                val imageUri = tempImageUri
                val photo =
                    Photo(dbphototitle = title, dbphotocontent = content, dbphotoimage = imageUri)
                Toast.makeText(requireContext(), "Your photo is added !", Toast.LENGTH_LONG).show()
                //provideInsertUseCase.photoExecute(photo)
                mViewModel.insertNewPhoto(photo)

                MAIN.navController.navigate(R.id.action_newPhotoFragment_to_newStoryFragment)
//                photoRepository.insertPhoto(photo)
//                activity?.supportFragmentManager
//                    ?.beginTransaction()
//                    ?.replace(R.id.flMain, AddNewStoryFragment())
//                    ?.commit()
//                overridePendingTransition(0, R.anim.open_activity)
//                finish()
            } else {
                Toast.makeText(requireContext(), "Please, write name and description photo !",
                    Toast.LENGTH_LONG).show()
            }
        }

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                MAIN.navController.navigate(R.id.action_newPhotoFragment_to_newStoryFragment)
            }
        }
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, callback)
    }

    private fun chooseImage() {
        val photoPickerIntent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        photoPickerIntent.type = "image/*"
        //photoPickerIntent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
        startActivityForResult(photoPickerIntent, Pick_image)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == AppCompatActivity.RESULT_OK && requestCode == Pick_image) {
            //Получаем URI изображения, преобразуем его в Bitmap
            //объект и отображаем в элементе ImageView нашего интерфейса:
            binding.ivNewPhotoBig.setImageURI(data?.data)
            tempImageUri = data?.data.toString()
            activity?.contentResolver?.takePersistableUriPermission(data?.data!!, Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }

    }

}

