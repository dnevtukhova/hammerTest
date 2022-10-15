package com.lobzhanidze.ordering_burgers.presentation.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lobzhanidze.ordering_burgers.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        openElementListFragment()
    }

    fun openElementListFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.fragment_container,
                ElementBurgerFragment(),
                ElementBurgerFragment.TAG
            )
            .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        supportActionBar
        findViewById<BottomNavigationView>(R.id.navigation)
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}