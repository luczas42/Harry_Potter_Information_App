package br.com.hp_app.ui.elixirs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import br.com.hp_app.data.model.Elixirs
import br.com.hp_app.databinding.FragmentElixirDetailsBinding
import br.com.hp_app.ui.adapters.RecyclerElixirIngredientsAdapter
import br.com.hp_app.ui.adapters.RecyclerElixirInventorsAdapter
import br.com.hp_app.ui.viewmodel.DetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ElixirsDetailsFragment : Fragment() {

    private val viewModel by viewModel<DetailsViewModel>()
    private lateinit var inventorsAdapter: RecyclerElixirInventorsAdapter
    private lateinit var ingredientsAdapter: RecyclerElixirIngredientsAdapter

    private var _binding: FragmentElixirDetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentElixirDetailsBinding.inflate(inflater, container, false)

        getSelectedElixir()

        populateFields()

        return binding.root

    }

    private fun populateFields() {
        viewModel.selectedElixir.observe(requireActivity()) { elixir ->
            binding.tvName.text = elixir.name
            binding.tvEffectsDescription.text = elixir.effect
            binding.tvSideEffectsDescription.text = elixir.sideEffects
            binding.tvCharacteristicsDescription.text = elixir.characteristics
            binding.tvTimeDescription.text = elixir.time
            binding.tvDifficultyDescription.text = elixir.difficulty
            binding.tvManufacturerDescription.text = elixir.manufacturer

            setupIngredientsRecyclerView(elixir)
            setupInventorsRecyclerView(elixir)
        }
    }

    private fun setupIngredientsRecyclerView(elixirs: Elixirs) {
        binding.rvIngredients.layoutManager = GridLayoutManager(context, 2)
        setIngredientsAdapter(elixirs)
    }

    private fun setIngredientsAdapter(elixirs: Elixirs) {
        ingredientsAdapter = RecyclerElixirIngredientsAdapter(elixirs.ingredients)
        binding.rvIngredients.adapter = ingredientsAdapter
    }

    private fun setupInventorsRecyclerView(elixirs: Elixirs) {
        binding.rvInventors.layoutManager = GridLayoutManager(context, 2)
        setInventorsAdapter(elixirs)
    }

    private fun setInventorsAdapter(elixirs: Elixirs) {
        inventorsAdapter = RecyclerElixirInventorsAdapter(elixirs.inventors)
        binding.rvInventors.adapter = inventorsAdapter
    }

    private fun getSelectedElixir() {
        requireActivity().intent.getStringExtra("elixirId")
            ?.let { viewModel.getSelectedElixir(it) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}