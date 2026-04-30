package com.example.toolbar


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.toolbar.databinding.ActivityMain2Binding

import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity2 : AppCompatActivity(){
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main2)
        setupToolbar()
        setupTabs()
        setupButtomNavigation()
    }

    private fun setupToolbar(){
        binding.contentToolbar.toolbar.title = "Activity Dos"
        binding.contentToolbar.toolbar.setNavigationOnClickListener { onBackPressed() }
        binding.contentToolbar.toolbar.setOnMenuItemClickListener { item ->
            when(item.itemId){
                R.id.menu1 ->{
                    //Tarea a relaizar
                    true
                }
                R.id.menu2 ->{
                    //Tarea a relizar
                    true
                }
                else -> false
            }
        }
    }

    private  fun setupTabs(){
        val viewPager = binding.viewPager
        viewPager.adapter = viewPagerAdapter(this)

        val tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, viewPager){ tab, position ->
            when(position){
                0 -> tab.text = "TAB UNO"
                1 -> tab.text = "TAB DOS"
                2 -> tab.text = "TAB TRES"
            }
        }.attach() //Para mostrar las pestañas

        // Seleccionar TAB DOS por defecto (índice 1)
        viewPager.setCurrentItem(1, false)
    }

    private fun setupButtomNavigation(){
        binding.btnNavigation.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.btn1 ->
                    startActivity(Intent(this, MainActivity::class.java))
                R.id.btn2 ->
                    Toast.makeText(this, "Favorito", Toast.LENGTH_SHORT).show()
                R.id.btn3 ->
                    Toast.makeText(this, "Música", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }
}