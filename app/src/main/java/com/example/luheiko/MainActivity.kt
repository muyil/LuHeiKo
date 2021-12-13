package com.example.luheiko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.luheiko.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(),BottomNavigationView.OnNavigationItemSelectedListener {

    private  lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        navController.navigate(R.id.temperatureFragment)

        val nav: BottomNavigationView = binding.bottomNavigation
        nav.selectedItemId = R.id.temperatureFragment
        nav.setOnItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.temperatureFragment -> { navController.navigate(R.id.temperatureFragment) }
            R.id.humidityFragment -> { navController.navigate(R.id.humidityFragment) }
            R.id.doorAccesFragment -> { navController.navigate(R.id.doorAccesFragment) }
        }
        return true
    }
}