package com.jordicuevas.medifinderapp.ui

import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.jordicuevas.medifinderapp.R
import com.jordicuevas.medifinderapp.data.remote.model.ListManager
import com.jordicuevas.medifinderapp.data.remote.model.LocalStorage.manager
import com.jordicuevas.medifinderapp.databinding.ActivityMainBinding
import com.jordicuevas.medifinderapp.ui.adapter.TabPageAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        manager = ListManager(this)
        setUpTabBar()
    }

    private fun setUpTabBar() {
        val adapter = TabPageAdapter(this, binding.tabLayout.tabCount)
        binding.viewPager.adapter = adapter

        binding.viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback()
        {
            override fun onPageSelected(position: Int) {
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position))
            }
        })

        binding.tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab){
                binding.viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabReselected(p0: TabLayout.Tab?) {

            }
        })

    }

}