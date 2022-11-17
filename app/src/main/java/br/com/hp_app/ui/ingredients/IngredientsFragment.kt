package br.com.hp_app.ui.ingredients

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.hp_app.databinding.FragmentIngredientsBinding
import br.com.hp_app.ui.DetalhesActivity
import br.com.hp_app.ui.adapters.RecyclerIngredientsAdapter
import br.com.hp_app.ui.adapters.RecyclerSpellsAdapter
import br.com.hp_app.ui.viewmodel.ListasViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class IngredientsFragment : Fragment() {

    private var _binding: FragmentIngredientsBinding? = null
    private val viewModel by viewModel<ListasViewModel>()
    private lateinit var adapter: RecyclerIngredientsAdapter



    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentIngredientsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        if (activity != null && isAdded) {

            configuraRecyclerView()

        }

        return root
    }


    private fun configuraRecyclerView() {
        viewModel.pegaListaIngredients()
        viewModel.listaIngredients.observe(requireActivity()) { ingredients ->
            binding.recyclerViewIngredients.layoutManager = LinearLayoutManager(context)
            adapter = RecyclerIngredientsAdapter(ingredients)
            binding.recyclerViewIngredients.adapter = adapter
            adapter.itemClickListener = { ingredientId ->
                val intent = Intent(activity, DetalhesActivity::class.java)
                intent.putExtra("ingredientId", ingredientId)
                startActivity(intent)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.listaIngredients.removeObservers(requireActivity())

        _binding = null
    }

}