package com.example.appdesignmaterial.ui

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.*
import com.example.appdesignmaterial.R
import com.example.appdesignmaterial.iu.iu.fragment.UniverseFragment
import com.example.appdesignmaterial.ui.fragment.DailyImageFragment

class MainActivity : AppCompatActivity() {

    private val appThemeSaved by lazy { AppThemePreferenceDelegate(this) }

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(appThemeSaved.getSavedTheme())

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = UniverseFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_daily, fragment)
        transaction.disallowAddToBackStack()
        transaction.commit()
    }

}