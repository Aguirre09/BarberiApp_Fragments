package com.example.barber_proe.ui


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.barber_proe.Login
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.example.barber_proe.R

import android.view.Menu
import android.widget.Toast
import com.example.barber_proe.MainActivity
import kotlinx.android.synthetic.main.fragment_profile.view.*

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val root =  inflater.inflate(R.layout.fragment_profile, container, false)
        root.Exit.setOnClickListener {
            val intent= Intent(context,Login::class.java)


            startActivity(intent)
        }
        return root
    }



}
