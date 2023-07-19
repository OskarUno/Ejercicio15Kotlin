package com.awakelab.oskar.ejercicio15kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.awakelab.oskar.ejercicio15kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
    }

    private fun initAdapter() {
       val adapter = Adapter()
        val pokedex = Pokedex.getPokedex()
        adapter.setData(pokedex)
        binding.RV.adapter = adapter  //Asignar el recycleView con el adapter
    }
}