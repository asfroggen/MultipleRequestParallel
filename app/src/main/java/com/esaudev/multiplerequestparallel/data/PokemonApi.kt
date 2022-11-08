package com.esaudev.multiplerequestparallel.data

import com.esaudev.multiplerequestparallel.model.PokemonAbilities
import com.esaudev.multiplerequestparallel.model.PokemonTypes
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET("https://pokeapi.co/api/v2/pokemon/{pokemonId}")
    suspend fun fetchPokemonAbilities(
        @Path("pokemonId") pokemonId: Int
    ): PokemonAbilities

    @GET("https://pokeapi.co/api/v2/pokemon/{pokemonId}")
    suspend fun fetchPokemonTypes(
        @Path("pokemonId") pokemonId: Int
    ): PokemonTypes

}