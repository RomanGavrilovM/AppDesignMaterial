package com.example.appdesignmaterial.iu.iu.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.navigation.NavigationView
import com.example.appdesignmaterial.R

class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {

    private lateinit var navigationView: NavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_menu_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigationView = view.findViewById(R.id.navigation_view)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_one -> {
                    val fragment = CollapsingToolbarFragment()
                    val transaction = requireActivity().supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragment_daily, fragment)
                    transaction.addToBackStack(null)
                    transaction.commit()
                }
                R.id.navigation_two -> {
                    val fragment = MotionLayoutFragment()
                    val transaction = requireActivity().supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragment_daily, fragment)
                    transaction.addToBackStack(null)
                    transaction.commit()
                }
            }
            true
        }
    }
}