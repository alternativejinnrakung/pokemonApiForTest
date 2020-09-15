package com.example.pokemonlist

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.base.BindingFragment
import com.example.data.remote.model.pokemon.PokemonResponse
import com.example.imagefromapi.R
import com.example.imagefromapi.databinding.FragmentPokemonListBinding
import com.example.pokemonlist.viewpokemon.ViewPokemonFragment
import org.koin.androidx.viewmodel.ext.android.getViewModel

class PokemonListFragment : BindingFragment<FragmentPokemonListBinding>() {
    override fun getLayoutResId(): Int {
        return R.layout.fragment_pokemon_list
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.model = getViewModel()
        binding.lifecycleOwner = this
        binding.model!!.states.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is Loading -> showLoading()
                is ImageListLoaded -> showData(state.data)
                is Failed -> showError(state.error)
            }
        })
        binding.model!!.getImageList()
    }

    private fun showLoading(){
        binding.progress.visibility = View.VISIBLE
    }

    private fun showData(response: PokemonResponse){
        binding.progress.visibility = View.GONE
        val list = response.pokemon_entries
        val validPokemon = arguments?.getString("INPUT_POKEMON") ?: ""
        binding.recyclerView.withModels {
            for (i in list.indices) {
                if (validPokemon == list[i].pokemon_species.name && validPokemon.isNotEmpty()) {
                    pokemonListRowEpoxyHolder {
                        id(i)
                        pokemonName(list[i].pokemon_species.name)
                        entryNumber("${list[i].entry_number}")
                        onClick { _ ->
                            goToPokemonDetail(list[i].pokemon_species.url)
                        }
                    }
                }
            }
        }
    }

    private fun goToPokemonDetail(uri: String) {
        val fragment = ViewPokemonFragment()
        val bundle = Bundle()
        bundle.putString("LINK_URL", uri)
        fragment.arguments = bundle
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun showError(error: Throwable){
        binding.progress.visibility = View.GONE
        binding.middleText.text = error.message ?: ""
        binding.middleText.visibility = View.VISIBLE
    }
}