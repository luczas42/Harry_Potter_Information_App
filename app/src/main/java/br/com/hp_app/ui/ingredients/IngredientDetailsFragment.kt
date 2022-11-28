package br.com.hp_app.ui.spells

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.hp_app.databinding.FragmentIngredientDetailsBinding
import br.com.hp_app.ui.viewmodel.DetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class IngredientDetailsFragment : Fragment() {

    private val viewModel by viewModel<DetailsViewModel>()

    private var _binding: FragmentIngredientDetailsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentIngredientDetailsBinding.inflate(inflater, container, false)

        getSelectedIngredient()

        populateFields()

        return binding.root
    }

    private fun populateFields() {
        viewModel.selectedIngredient.observe(requireActivity()) { ingredient ->
            binding.tvName.text = ingredient.name

        }
    }

    private fun getSelectedIngredient() {
        requireActivity().intent.getStringExtra("ingredientId")
            ?.let { viewModel.getSelectedIngredient(it) }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}