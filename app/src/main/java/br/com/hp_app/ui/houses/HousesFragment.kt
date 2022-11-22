package br.com.hp_app.ui.houses

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.hp_app.data.model.Houses
import br.com.hp_app.databinding.FragmentHousesBinding
import br.com.hp_app.ui.DetailsActivity
import br.com.hp_app.ui.adapters.RecyclerHousesAdapter
import br.com.hp_app.ui.viewmodel.ListsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HousesFragment : Fragment() {

    private var _binding: FragmentHousesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel by viewModel<ListsViewModel>()
    private lateinit var adapter: RecyclerHousesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHousesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        requireActivity().invalidateOptionsMenu()
        setupRecyclerView()

        return root
    }

    private fun onSearch() {
        viewModel.searchQuery.observe(requireActivity()) { query ->
            if (query != "") {
                adapter.filterItems(query)
            } else {
                adapter.onFilterCleared(viewModel.houseList.value)
            }
        }
    }

    private fun setupRecyclerView() {
        viewModel.getHouseList()
        viewModel.houseList.observe(requireActivity()) { houses ->
            binding.recyclerViewHouses.layoutManager = LinearLayoutManager(context)
            setAdapter(houses)
            setItemClickListener()
            onAdapterSuccess()
            onSearch()

        }
    }

    private fun onAdapterSuccess() {
        if (adapter.itemCount > 0) {
            binding.recyclerViewHouses.visibility = View.VISIBLE
            binding.loading.visibility = View.GONE
        }
    }

    private fun setItemClickListener() {
        adapter.itemClickListener = { houseId ->
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("houseId", houseId)
            startActivity(intent)
        }
    }

    private fun setAdapter(houses: List<Houses>) {
        adapter = RecyclerHousesAdapter(houses)
        binding.recyclerViewHouses.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.houseList.removeObservers(requireActivity())
        _binding = null

    }
}