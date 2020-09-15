package com.example.data.remote.model.pokemon.pokemondetail

import com.google.gson.annotations.SerializedName

data class PokemonDetailResponse (
    @SerializedName("base_happiness") val base_happiness : Int,
    @SerializedName("capture_rate") val capture_rate : Int,
    @SerializedName("color") val color : Color,
    @SerializedName("egg_groups") val egg_groups : List<Egg_groups>,
    @SerializedName("evolution_chain") val evolution_chain : Evolution_chain,
    @SerializedName("evolves_from_species") val evolves_from_species : Evolves_from_species,
    @SerializedName("flavor_text_entries") val flavor_text_entries : List<Flavor_text_entries>,
    @SerializedName("form_descriptions") val form_descriptions : List<String>,
    @SerializedName("forms_switchable") val forms_switchable : Boolean,
    @SerializedName("gender_rate") val gender_rate : Int,
    @SerializedName("genera") val genera : List<Genera>,
    @SerializedName("generation") val generation : Generation,
    @SerializedName("growth_rate") val growth_rate : Growth_rate,
    @SerializedName("habitat") val habitat : Habitat,
    @SerializedName("has_gender_differences") val has_gender_differences : Boolean,
    @SerializedName("hatch_counter") val hatch_counter : Int,
    @SerializedName("id") val id : Int,
    @SerializedName("is_baby") val is_baby : Boolean,
    @SerializedName("is_legendary") val is_legendary : Boolean,
    @SerializedName("is_mythical") val is_mythical : Boolean,
    @SerializedName("name") val name : String,
    @SerializedName("names") val names : List<Names>,
    @SerializedName("order") val order : Int,
    @SerializedName("pal_park_encounters") val pal_park_encounters : List<Pal_park_encounters>,
    @SerializedName("pokedex_numbers") val pokedex_numbers : List<Pokedex_numbers>,
    @SerializedName("shape") val shape : Shape,
    @SerializedName("varieties") val varieties : List<Varieties>
)