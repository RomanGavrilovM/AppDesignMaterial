package com.example.appdesignmaterial.iu.iu.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.appdesignmaterial.R

class TextSampleFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_text_sample, container,false)
    }
}