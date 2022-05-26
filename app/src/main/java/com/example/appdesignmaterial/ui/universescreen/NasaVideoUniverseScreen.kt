package com.example.appdesignmaterial.iu.iu.universescreen

import androidx.fragment.app.Fragment
import com.example.appdesignmaterial.domain.entity.UniversePageType
import com.example.appdesignmaterial.iu.iu.adapter.UniverseScreen
import com.example.appdesignmaterial.iu.iu.fragment.EarthFragment
import com.example.appdesignmaterial.iu.iu.fragment.NasaVideoFragment

class NasaVideoUniverseScreen : UniverseScreen {
    override fun getFragment(): Fragment {
        return NasaVideoFragment()
    }

    override fun getType(): UniversePageType {
        return UniversePageType.Video
    }

}