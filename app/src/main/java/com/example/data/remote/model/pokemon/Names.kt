package com.example.data.remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class Names (

	@SerializedName("language") val language : Language,
	@SerializedName("name") val name : String
)