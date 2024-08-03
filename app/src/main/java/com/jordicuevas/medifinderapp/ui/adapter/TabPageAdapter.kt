package com.jordicuevas.medifinderapp.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jordicuevas.medifinderapp.ui.fragments.HomeFragment
import com.jordicuevas.medifinderapp.ui.fragments.MedListFragment
import com.jordicuevas.medifinderapp.ui.fragments.SearchFragment

class TabPageAdapter(activity: FragmentActivity, private val tabCount: Int) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = tabCount

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> SearchFragment()
            2 -> MedListFragment()
            else -> HomeFragment()
        }
    }


}