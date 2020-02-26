package com.example.barber_proe

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import com.example.barber_proe.ui.InicioFragment
import com.example.barber_proe.ui.ProcesoFragment
import com.example.barber_proe.ui.ProfileFragment
import com.example.barber_proe.ui.StoreFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // se carga por defecto el primer fragmento
        loadFragment(InicioFragment())

        bottomNavigationView.setOnNavigationItemSelectedListener  {  menuItem ->
            when {
                menuItem.itemId == R.id.navigationExplore -> {
                    loadFragment(InicioFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                menuItem.itemId == R.id.navigationDashboard -> {
                    loadFragment(ProcesoFragment())
                    return@setOnNavigationItemSelectedListener true
                }


                menuItem.itemId == R.id.navigationAccount -> {
                    loadFragment(ProfileFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                menuItem.itemId == R.id.navigationStore -> {
                    loadFragment(StoreFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }


        }

    }

    private fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().also { fragmentTransaction ->
           fragmentTransaction.replace(R.id.fragmentContainer,fragment)
            fragmentTransaction.commit()

        }
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
        super.onBackPressed()
    }
}