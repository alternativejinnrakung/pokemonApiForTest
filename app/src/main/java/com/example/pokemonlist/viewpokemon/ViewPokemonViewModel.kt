package com.example.pokemonlist.viewpokemon

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.base.CoroutinesViewModel
import com.example.domain.PokemonDetailRepository
import kotlinx.coroutines.launch

class ViewPokemonViewModel(private val pokemonDetailRepository: PokemonDetailRepository) : CoroutinesViewModel() {
    private val _states = MutableLiveData<ViewPokemonStates>()
    val states: LiveData<ViewPokemonStates>
        get() = _states

    fun getPokemonDetail(pokemonId: String){
        mainScope.launch {
            _states.value = Loading
            try {
                val response = pokemonDetailRepository.getPokemonDetail(pokemonId)
                _states.value = isDetailLoaded(response)
            } catch (e: Throwable) {
                _states.value = Failed(e)
            }
        }
    }
}