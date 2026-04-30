package com.example.toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.toolbar.Fragment1
import com.example.toolbar.Fragment2
class viewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment){

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return  when(position){
            0 -> Fragment1()
            1 -> Fragment2()
            2 -> Fragment3()
            else -> Fragment2()
        }
    }
}