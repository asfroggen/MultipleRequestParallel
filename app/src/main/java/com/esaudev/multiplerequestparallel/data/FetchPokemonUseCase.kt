package com.esaudev.multiplerequestparallel.data

import com.esaudev.multiplerequestparallel.model.PokemonDetail
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FetchPokemonUseCase () {

    private fun provideApi(): PokemonApi {
        return  Retrofit.Builder()
            .baseUrl("https://pokeapi.co/")
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonApi::class.java)
    }

    suspend operator fun invoke(pokemonId: Int): Result<PokemonDetail> = withContext(Dispatchers.IO) {
        try {
            val pokemonApi = provideApi()

            val pokemonAbilities = async { pokemonApi.fetchPokemonAbilities(pokemonId = pokemonId) }
            val pokemonTypes = async { pokemonApi.fetchPokemonTypes(pokemonId = pokemonId) }

            Result.success(
                PokemonDetail(
                    pokemonTypes = pokemonTypes.await().types.map { it.type.name},
                    pokemonAbilities = pokemonAbilities.await().abilities.map { it.ability.name }
                )
            )
        } catch (e: Exception) {
            Result.failure<PokemonDetail>(Exception("Something went wrong"))
        }
    }
}