package com.androidcenter.bottombardemo

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.androidcenter.bottombardemo.databinding.ActivityMainBinding
import com.androidcenter.bottombardemo.fragments.DashboardFragment
import com.androidcenter.bottombardemo.fragments.HomeFragment
import com.androidcenter.bottombardemo.fragments.NotificationsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbar:ActionBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCurrentFragment(HomeFragment())
        toolbar=supportActionBar!!
        // setting the title to our activity
        toolbar.title="Home"
        val navView: BottomNavigationView = binding.navView
        navView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_home->{
                    toolbar.title="Home"
                    setCurrentFragment(HomeFragment())}
                R.id.navigation_dashboard->{
                    toolbar.title="Dashboard"
                    setCurrentFragment(DashboardFragment())
                }
                R.id.navigation_notifications->{
                    toolbar.title="Notification"
                    setCurrentFragment(NotificationsFragment())
                }
            }
            true
        }
    }

    // method to set the fragment on navigation item click
    private fun setCurrentFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment_activity_main, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}