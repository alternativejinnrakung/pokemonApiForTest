package com.example.data.remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class Pokemon_entries (

	@SerializedName("entry_number") val entry_number : Int,
	@SerializedName("pokemon_species") val pokemon_species : Pokemon_species
)