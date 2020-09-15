package com.example.data.remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class Descriptions (
	@SerializedName("description") val description : String,
	@SerializedName("language") val language : Language
)