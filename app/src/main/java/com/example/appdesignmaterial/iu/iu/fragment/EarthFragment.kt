package com.example.appdesignmaterial.iu.iu.fragment

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.api.load
import com.example.appdesignmaterial.R
import com.example.appdesignmaterial.databinding.FragmentEarthBinding
import com.example.appdesignmaterial.domain.entity.EarthImage
import com.example.appdesignmaterial.iu.iu.viewmodel.EarthViewModel

class EarthFragment : Fragment() {

    private val viewModel by viewModels<EarthViewModel>()
    private lateinit var binding : FragmentEarthBinding
    private lateinit var earthImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getImageDataEarth().observe(this, { earthImage -> renderData(earthImage) })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEarthBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        earthImageView = view.findViewById(R.id.earth_image_view)
    }

    private fun renderData(earthImage: EarthImage) {
        when (earthImage) {
            is EarthImage.SuccessEarth -> {
                val serverResponseData = earthImage.serverResponseData
                val url: String?
                url = serverResponseData.url
                if (url.isNullOrEmpty()) {
                } else {
                    earthImageView.load(url) {
                        lifecycle(this@EarthFragment)
                        error(R.drawable.ic_error)
                        placeholder(R.drawable.ic_placeholder)
                    }
                }
            }
            is EarthImage.Loading -> {

            }
            is EarthImage.Error -> {

            }
        }
    }
}