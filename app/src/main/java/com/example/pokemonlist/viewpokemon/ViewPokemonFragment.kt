package com.example.pokemonlist.viewpokemon

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.base.BindingFragment
import com.example.data.remote.model.pokemon.pokemondetail.PokemonDetailResponse
import com.example.imagefromapi.R
import com.example.imagefromapi.databinding.FragmentViewPokemonBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel

class ViewPokemonFragment : BindingFragment<FragmentViewPokemonBinding>() {
    override fun getLayoutResId(): Int {
        return R.layout.fragment_view_pokemon
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.model = getViewModel()
        binding.lifecycleOwner = this
        binding.model!!.states.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is Loading -> showLoading()
                is isDetailLoaded -> showData(state.data)
                is Failed -> showError(state.error)
            }
        })
        val url = arguments?.getString("LINK_URL") ?: ""
        binding.model!!.getPokemonDetail(url.takeLast(2))

        binding.backBtn.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    private fun showLoading(){
        binding.progress.visibility = View.VISIBLE
    }

    private fun showError(error: Throwable){
        binding.progress.visibility = View.GONE
        binding.detailText.text = error.message ?: ""
    }

    private fun showData(data: PokemonDetailResponse) {
        binding.progress.visibility = View.GONE
        binding.detailText.text = data.toString()
    }
}