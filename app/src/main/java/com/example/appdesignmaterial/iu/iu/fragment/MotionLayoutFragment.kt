package com.example.appdesignmaterial.iu.iu.fragment

import android.os.*
import android.view.*
import androidx.fragment.app.Fragment
import com.example.appdesignmaterial.databinding.*

class MotionLayoutFragment : Fragment() {
    private lateinit var binding: FragmentMotionLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMotionLayoutBinding.inflate(layoutInflater)
        return  binding.root
    }
}