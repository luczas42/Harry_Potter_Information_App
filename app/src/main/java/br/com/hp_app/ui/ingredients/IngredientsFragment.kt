package br.com.hp_app.ui.ingredients

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.hp_app.data.model.Ingredients
import br.com.hp_app.databinding.FragmentIngredientsBinding
import br.com.hp_app.ui.DetailsActivity
import br.com.hp_app.ui.adapters.RecyclerIngredientsAdapter
import br.com.hp_app.ui.viewmodel.ListsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class IngredientsFragment : Fragment() {

    private var _binding: FragmentIngredientsBinding? = null
    private val viewModel by viewModel<ListsViewModel>()
    private lateinit var adapter: RecyclerIngredientsAdapter


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentIngredientsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupRecyclerView()

        return root
    }


    private fun setupRecyclerView() {
        viewModel.getIngredientList()
        viewModel.ingredientList.observe(requireActivity()) { ingredients ->
            binding.recyclerViewIngredients.layoutManager = LinearLayoutManager(context)
            setAdapter(ingredients)
            setItemClickListener()
        }
    }

    private fun setAdapter(ingredients: List<Ingredients>) {
        adapter = RecyclerIngredientsAdapter(ingredients)
        binding.recyclerViewIngredients.adapter = adapter
    }

    private fun setItemClickListener() {
        adapter.itemClickListener = { ingredientId ->
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("ingredientId", ingredientId)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.ingredientList.removeObservers(requireActivity())

        _binding = null
    }

}