package com.example.kotlin.favoritemovie

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MinActivity: Activity() {

    class MainActivity : AppCompatActivity() {

        //Global variables
        private lateinit var binding: ActivityMainBinding
        private val viewModel: MainViewModel by viewModels()
        private lateinit var currentFragment: Fragment
        private var currentMenuOption: String? = null


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            initializeBinding()
            initializeObservers()
            initializeListeners()
            exchangeCurrentFragment(PokedexFragment(), Constants.MENU_POKEDEX)

        }

        private fun initializeListeners(){
            binding.appBarMain.llPokedex.setOnClickListener {
                selectMenuOption(Constants.MENU_POKEDEX)
            }

            binding.appBarMain.llSearch.setOnClickListener {
                selectMenuOption(Constants.MENU_SEARCH)
            }
        }

        private fun initializeBinding() {
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
        }

        private fun initializeObservers() {

        }

        private fun exchangeCurrentFragment(newFragment: Fragment, newMenuOption:String){
            currentFragment = newFragment

            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_content_main,currentFragment)
                .commit()

            currentMenuOption = newMenuOption
        }

        private fun selectMenuOption(menuOption:String){
            if(menuOption == currentMenuOption){
                return
            }

            when(menuOption){
                Constants.MENU_POKEDEX -> exchangeCurrentFragment(PokedexFragment(),Constants.MENU_POKEDEX)
                Constants.MENU_SEARCH -> exchangeCurrentFragment(SearchFragment(),Constants.MENU_SEARCH)
            }
        }

    }
}