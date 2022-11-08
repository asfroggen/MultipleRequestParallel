package com.esaudev.multiplerequestparallel.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esaudev.multiplerequestparallel.data.FetchPokemonUseCase
import com.esaudev.multiplerequestparallel.model.PokemonDetail
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class MainViewModel: ViewModel() {

    val pokemonDetail = MutableLiveData<PokemonDetail>()
    private val fetchPokemonUseCase = FetchPokemonUseCase()

    fun fetchPokemonDetail(pokemonId: Int) {
        viewModelScope.launch {
            val timeElapsed = measureTimeMillis {
                fetchPokemonUseCase(pokemonId = pokemonId)
            }
            Log.d("TIME_TEST", timeElapsed.toString())
            val result = fetchPokemonUseCase(pokemonId = pokemonId)
            if (result.isSuccess) pokemonDetail.postValue(result.getOrNull())
        }
    }

}