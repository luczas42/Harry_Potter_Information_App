package br.com.hp_app.ui.elixirs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import br.com.hp_app.data.model.Elixirs
import br.com.hp_app.databinding.FragmentDetalhesElixirsBinding
import br.com.hp_app.ui.adapters.RecyclerElixirIngredientsAdapter
import br.com.hp_app.ui.adapters.RecyclerElixirInventorsAdapter
import br.com.hp_app.ui.viewmodel.DetalhesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ElixirsDetalhesFragment : Fragment() {

    private val viewModel by viewModel<DetalhesViewModel>()
    private lateinit var inventorsAdapter: RecyclerElixirInventorsAdapter
    private lateinit var ingredientsAdapter: RecyclerElixirIngredientsAdapter

    private var _binding: FragmentDetalhesElixirsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDetalhesElixirsBinding.inflate(inflater, container, false)

        pegaElixirSelecionado()

        populaCampos()

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun populaCampos() {
        viewModel.selectedElixir.observe(requireActivity()) { elixir ->
            binding.tvName.text = elixir.name
            binding.tvEffectsDescription.text = elixir.effect
            binding.tvSideEffectsDescription.text = elixir.sideEffects
            binding.tvCharacteristicsDescription.text = elixir.characteristics
            binding.tvTimeDescription.text = elixir.time
            binding.tvDifficultyDescription.text = elixir.difficulty
            binding.tvManufacturerDescription.text = elixir.manufacturer

            configuraIngredientsRecyclerView(elixir)
            configuraaInventorsRecyclerView(elixir)
        }
    }

    private fun configuraIngredientsRecyclerView(elixirs: Elixirs) {
        binding.rvIngredients.layoutManager = GridLayoutManager(context, 2)
        ingredientsAdapter = RecyclerElixirIngredientsAdapter(elixirs.ingredients)
        binding.rvIngredients.adapter = ingredientsAdapter
    }

    private fun configuraaInventorsRecyclerView(elixirs: Elixirs) {
        binding.rvInventors.layoutManager = GridLayoutManager(context, 2)
        inventorsAdapter = RecyclerElixirInventorsAdapter(elixirs.inventors)
        binding.rvInventors.adapter = inventorsAdapter
    }

    private fun pegaElixirSelecionado() {
        requireActivity().intent.getStringExtra("elixirId")
            ?.let { viewModel.pegaElixirSelecionado(it) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}