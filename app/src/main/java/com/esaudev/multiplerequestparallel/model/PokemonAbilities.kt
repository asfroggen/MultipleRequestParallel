package com.esaudev.multiplerequestparallel.model

data class PokemonAbilities(
    val abilities: List<PokemonAbility>
)

data class PokemonAbility(
    val ability: Ability
)

data class Ability(
    val name: String
)