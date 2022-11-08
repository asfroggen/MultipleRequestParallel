package com.esaudev.multiplerequestparallel.model

data class PokemonTypes(
    val types: List<PokemonType>
)

data class PokemonType(
    val type: Type
)

data class Type (
    val name: String
)
