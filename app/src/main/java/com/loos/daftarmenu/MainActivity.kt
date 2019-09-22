package com.loos.daftarmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.tabs_main
import kotlinx.android.synthetic.main.activity_main.viewpager_main

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpager_main.adapter=ViewPageAdapter(supportFragmentManager)
        tabs_main.setupWithViewPager(viewpager_main)
    }

    inner class ViewPageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        //list menampung object
        private val pages = listOf(
            MakananFragment.getInstance(), MinumanFragment.getInstance()
        )


        //Menentukan fragment yg akan dibuka
        override fun getItem(position: Int): Fragment {
            return pages[position]
        }

        override fun getCount(): Int {
            return pages.size
        }


        //Judul Tabs
        override fun getPageTitle(position: Int): CharSequence? {
            return when (position) {
                0 -> "Makanan"
                else -> "Minuman"

            }
        }
    }
}
