package com.example.pokemonlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.base.CoroutinesViewModel
import com.example.domain.PokemonListRepository
import kotlinx.coroutines.launch

class PokemonListViewModel(private val pokemonListRepository: PokemonListRepository) : CoroutinesViewModel() {
    private val _states = MutableLiveData<ImageListStates>()
    val states: LiveData<ImageListStates>
        get() = _states

    fun getImageList() {
        mainScope.launch {
            _states.value = Loading
            try {
                val response = pokemonListRepository.getPokemonList()
                _states.value = ImageListLoaded(response)
            } catch (e: Throwable) {
                _states.value = Failed(Throwable("รูปหายจ้า"))
            }
        }
    }
}