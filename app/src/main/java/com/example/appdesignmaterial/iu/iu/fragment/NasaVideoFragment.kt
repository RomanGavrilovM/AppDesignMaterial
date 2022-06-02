package com.example.appdesignmaterial.iu.iu.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.appdesignmaterial.databinding.FragmentNasaVideoBinding
import com.example.appdesignmaterial.domain.entity.NasaVideoSealed
import com.example.appdesignmaterial.iu.iu.viewmodel.EarthViewModel
import com.example.appdesignmaterial.iu.iu.viewmodel.NasaVideoViewModel


class NasaVideoFragment :Fragment() {
    private val viewModel by viewModels<NasaVideoViewModel>()
    private lateinit var binding : FragmentNasaVideoBinding
    private lateinit var nasaWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getVideoData().observe(this, { nasaVideo -> renderData(nasaVideo) })
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNasaVideoBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nasaWebView = view.findViewById(com.example.appdesignmaterial.R.id.nasa_web_view)
        nasaWebView.settings.javaScriptEnabled =true
    }


    private fun renderData(nasaVideo: NasaVideoSealed) {
        when (nasaVideo) {
            is NasaVideoSealed.Success -> {
                val serverResponseData = nasaVideo.serverResponseData
                val url: String?
                url = serverResponseData.url
                if (url.isNullOrEmpty()) {
                } else {
                    nasaWebView.loadUrl(url)
                }
            }
            is NasaVideoSealed.Loading -> {

            }
            is NasaVideoSealed.Error -> {

            }
        }
    }
}