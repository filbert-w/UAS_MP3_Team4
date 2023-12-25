package com.example.projectmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.projectmovie.databinding.ActivityMainBinding
import com.example.projectmovie.fragment.DataFragment
import com.example.projectmovie.fragment.FavoriteFragment
import com.example.projectmovie.fragment.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    replaceFragment(HomeFragment())
                    val l_layout : LinearLayout = findViewById(R.id.ly_input)
                    l_layout.visibility = VISIBLE
                }
                R.id.favorite -> {
                    replaceFragment(FavoriteFragment())
                    val l_layout : LinearLayout = findViewById(R.id.ly_input)
                    l_layout.visibility = GONE
                }

                else ->{

                }
            }
            true
        }

        binding.btnCari.setOnClickListener {
            showFragment()
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_data, fragment)
        fragmentTransaction.commit()
    }

    private fun showFragment() {
        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction = mFragmentManager.beginTransaction()
        val mFragment = DataFragment()

        val textCari = binding.etCari.text
        val mBundle = Bundle()
        mBundle.putString("carimovie", textCari.toString())
        mFragment.arguments = mBundle

        mFragmentTransaction.replace(R.id.fl_data,mFragment).commit()
    }
}