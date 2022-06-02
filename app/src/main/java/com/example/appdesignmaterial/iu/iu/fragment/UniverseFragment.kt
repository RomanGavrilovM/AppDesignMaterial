package com.example.appdesignmaterial.iu.iu.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.example.appdesignmaterial.R
import com.example.appdesignmaterial.iu.iu.adapter.UniverseScreen
import com.example.appdesignmaterial.iu.iu.universescreen.EarthUniverseScreen
import com.example.appdesignmaterial.iu.iu.adapter.UniverseStatePagerAdapter
import com.example.appdesignmaterial.iu.iu.universescreen.DailyUniverseScreen
import com.example.appdesignmaterial.iu.iu.viewmodel.EarthViewModel
import com.example.appdesignmaterial.iu.iu.viewmodel.UniverseViewModel
import com.example.appdesignmaterial.transformer.DepthPageTransformer
import com.example.appdesignmaterial.transformer.ZoomOutPageTransformer

class UniverseFragment: Fragment() {
    private val viewModel by viewModels<UniverseViewModel>()
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_universe, container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = view.findViewById(R.id.view_pager_universe)
        val adapter = UniverseStatePagerAdapter(this)
        val screens = viewModel.getFragmentUniverse().value as List<UniverseScreen>
        adapter.items = screens
        viewPager.adapter = adapter
        viewPager.setPageTransformer(DepthPageTransformer() )

        viewPager.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                //   Toast.makeText(context, "onPageScrolled Позиция ${position} Позиция2 ${positionOffset}",Toast.LENGTH_SHORT).show()
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                //     Toast.makeText(context, "onPageSelected Позиция ${position}",Toast.LENGTH_SHORT).show()
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                // Toast.makeText(context, "onPageScrollStateChanged Состояние ${state}",Toast.LENGTH_SHORT).show()
            }
        })

        tabLayout = view.findViewById(R.id.tab_layout_universe)

        TabLayoutMediator(tabLayout,viewPager){tab,position->
            val type = adapter.items[position]
            tab.text = type.getType().name
            tab.icon = ContextCompat.getDrawable(requireContext(),R.drawable.fly_image)
        }.attach()
    }


}