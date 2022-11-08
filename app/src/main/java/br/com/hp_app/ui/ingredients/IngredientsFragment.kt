package br.com.hp_app.ui.ingredients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.hp_app.databinding.FragmentIngredientsBinding
import br.com.hp_app.ui.adapters.RecyclerIngredientsAdapter
import br.com.hp_app.ui.adapters.RecyclerSpellsAdapter
import br.com.hp_app.ui.viewmodel.ListasViewModel

class IngredientsFragment : Fragment() {

    private var _binding: FragmentIngredientsBinding? = null
    private var viewModel: ListasViewModel = ListasViewModel()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentIngredientsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        configuraRecyclerView()

        return root
    }

    private fun configuraRecyclerView() {
        viewModel.pegaListaIngredients()
        viewModel.listaIngredients.observe(requireActivity()) { ingredients ->
            binding.recyclerViewIngredients.layoutManager = LinearLayoutManager(context)
            binding.recyclerViewIngredients.adapter = RecyclerIngredientsAdapter(ingredients)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}