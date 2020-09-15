package com.example.main

import android.os.Bundle
import android.view.View
import com.example.base.BindingFragment
import com.example.imagefromapi.R
import com.example.imagefromapi.databinding.FragmentMainBinding
import com.example.pokemonlist.PokemonListFragment

class MainFragment : BindingFragment<FragmentMainBinding>() {
    override fun getLayoutResId(): Int {
        return R.layout.fragment_main
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSearch.setOnClickListener {
            val fragment = PokemonListFragment()
            val bundle = Bundle()
            bundle.putString("INPUT_POKEMON", binding.tvSearch.text.toString())
            fragment.arguments = bundle
            if (savedInstanceState == null) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}