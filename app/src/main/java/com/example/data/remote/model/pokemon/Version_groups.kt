package com.example.data.remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class Version_groups (
	@SerializedName("name") val name : String,
	@SerializedName("url") val url : String
)