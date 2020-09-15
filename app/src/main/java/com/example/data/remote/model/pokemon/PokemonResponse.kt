package com.example.data.remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class PokemonResponse (
    @SerializedName("descriptions")
    val descriptions : List<Descriptions>,
    @SerializedName("id")
    val id : Int,
    @SerializedName("is_main_series")
    val is_main_series : Boolean,
    @SerializedName("name")
    val name : String,
    @SerializedName("names")
    val names : List<Names>,
    @SerializedName("pokemon_entries")
    val pokemon_entries : List<Pokemon_entries>,
    @SerializedName("region")
    val region : Region,
    @SerializedName("version_groups")
    val version_groups : List<Version_groups>
)