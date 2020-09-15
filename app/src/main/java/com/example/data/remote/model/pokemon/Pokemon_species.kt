package com.example.data.remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class Pokemon_species (

	@SerializedName("name") val name : String,
	@SerializedName("url") val url : String
)