package br.com.hp_app.ui.houses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.hp_app.databinding.FragmentHousesBinding
import br.com.hp_app.ui.adapters.RecyclerHousesAdapter
import br.com.hp_app.ui.viewmodel.ListasViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HousesFragment : Fragment() {

    private var _binding: FragmentHousesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel by viewModel<ListasViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHousesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        configuraRecyclerView()

        return root
    }

    private fun configuraRecyclerView() {
        viewModel.pegaListaHouses()
        viewModel.listaHouses.observe(requireActivity()) { houses ->
            binding.recyclerViewHouses.layoutManager = LinearLayoutManager(context)
            binding.recyclerViewHouses.adapter = RecyclerHousesAdapter(houses)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}