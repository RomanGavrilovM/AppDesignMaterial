package com.example.appdesignmaterial.iu.iu.universescreen

import androidx.fragment.app.Fragment
import com.example.appdesignmaterial.domain.entity.UniversePageType
import com.example.appdesignmaterial.iu.iu.adapter.UniverseScreen
import com.example.appdesignmaterial.iu.iu.fragment.DailyImageFragment
import com.example.appdesignmaterial.iu.iu.fragment.EarthFragment

class DailyUniverseScreen : UniverseScreen {
    override fun getFragment(): Fragment {
        return DailyImageFragment()
    }

    override fun getType(): UniversePageType {
        return UniversePageType.Daily
    }

}