package com.esaudev.multiplerequestparallel.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.esaudev.multiplerequestparallel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var binding : ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel.fetchPokemonDetail(pokemonId = 1)

        viewModel.pokemonDetail.observe(this) {
            binding.pokemonTypes.text = it.pokemonTypes.toString()
            binding.pokemonAbilities.text = it.pokemonAbilities.toString()
        }
    }
}