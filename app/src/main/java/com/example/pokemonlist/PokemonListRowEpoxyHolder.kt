package com.example.pokemonlist

import android.view.View
import android.widget.Button
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.imagefromapi.R
import com.example.widget.KotlinEpoxyHolder

@EpoxyModelClass(layout = R.layout.epoxy_holder_pokemon_list_row)
abstract class PokemonListRowEpoxyHolder : EpoxyModelWithHolder<PokemonListHolder>(){
    @EpoxyAttribute
    lateinit var pokemonName: String

    @EpoxyAttribute
    lateinit var entryNumber: String

    @EpoxyAttribute
    lateinit var onClick: View.OnClickListener

    override fun bind(holder: PokemonListHolder) {
        holder.pokemonName.text = pokemonName
        holder.entryNumber.text = entryNumber
        holder.button.setOnClickListener {
            onClick.onClick(it)
        }
    }
}

class PokemonListHolder: KotlinEpoxyHolder() {
    val pokemonName by bind<TextView>(R.id.pokemon_name)
    val entryNumber by bind<TextView>(R.id.entry_number)
    val button by bind<Button>(R.id.button)
}