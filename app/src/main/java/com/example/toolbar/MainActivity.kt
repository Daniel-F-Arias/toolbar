package com.example.toolbar

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import com.example.toolbar.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupToolbar()
    }
    private fun setupToolbar() {
        val toolbar = binding.contentToolbar.toolbar
        toolbar.title = "Activity Uno"
        toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu1 -> {
                    //Tarea a realizar
                    Toast.makeText(this, "Menú 1", Toast.LENGTH_LONG).show()
                    true
                }
                R.id.menu2 -> {
                    //Tarea a realizar
                    Toast.makeText(this, "Menú 2", Toast.LENGTH_LONG).show()
                    true
                }
                else -> false
            }
        }
        setupDrawer(toolbar)
    }
    private fun setupDrawer(toolbar: Toolbar) {
        val drawerLayout = binding.drawerLayout
        val navigationView = binding.navView
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.openDrawer,
            R.string.closeDrawer
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        setupDrawerMenuActions(navigationView, drawerLayout)
    }
    /**
    Maneja los clicks del menú lateral (NavigationView)
     **/
    private fun setupDrawerMenuActions(navigationView: NavigationView, drawerLayout: DrawerLayout) {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_item1 ->
                    startActivity(Intent(this, MainActivity2::class.java))
                R.id.nav_item2 ->
                    Toast.makeText(this, "Opcion 2", Toast.LENGTH_LONG).show()
            }
            // cerrar drawer después del click
            drawerLayout.closeDrawers()
            true
        }
    }
}