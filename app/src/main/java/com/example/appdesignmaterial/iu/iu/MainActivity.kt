package com.example.appdesignmaterial.iu.iu

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.appdesignmaterial.R
import com.example.appdesignmaterial.databinding.ActivityMainBinding
import com.example.appdesignmaterial.iu.iu.fragment.DailyImageFragment
import com.example.appdesignmaterial.iu.iu.fragment.UniverseFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO)
        setTheme(Const.currentTheme);
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*   val fragment = DailyImageFragment()
           val transaction = supportFragmentManager.beginTransaction()
           transaction.replace(R.id.fragment_daily, fragment)
           transaction.disallowAddToBackStack()
           transaction.commit()*/
        val fragment = UniverseFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_daily, fragment)
        transaction.disallowAddToBackStack()
        transaction.commit()

    }

}