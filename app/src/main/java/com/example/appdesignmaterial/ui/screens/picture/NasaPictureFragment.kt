package com.example.appdesignmaterial.ui.screens.picture

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.appdesignmaterial.R
import com.example.appdesignmaterial.data.app
import com.example.appdesignmaterial.databinding.FragmentNasaPictureBinding

class NasaPictureFragment : Fragment(R.layout.fragment_nasa_picture) {

    private val binding by viewBinding(FragmentNasaPictureBinding::bind)

    private val viewModel: NasaPictureContract.ViewModel by viewModels {
        NasaPictureViewModelFactory(
            requireContext().app.nasaPictureOfTheDayRepo
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
    }

    private fun initViewModel() {
        viewModel.nasaPictureLiveData.observe(this) { nasaPictureEntity->
            Glide.with(this).load(nasaPictureEntity.url).into(binding.nasaPictureImageView)
            binding.nasaPictureDescriptionTextView.text = nasaPictureEntity.explanation
        }

        viewModel.getData()
    }
}