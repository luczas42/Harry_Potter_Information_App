package br.com.hp_app.ui.houses

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import br.com.hp_app.R
import br.com.hp_app.databinding.FragmentDetalhesHousesBinding
import br.com.hp_app.data.model.Houses
import br.com.hp_app.ui.adapters.RecyclerHeadsAdapter
import br.com.hp_app.ui.adapters.RecyclerTraitsAdapter
import br.com.hp_app.ui.viewmodel.DetalhesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HousesDetalhesFragment : Fragment() {

    private val viewModel by viewModel<DetalhesViewModel>()
    private lateinit var headsAdapter: RecyclerHeadsAdapter
    private lateinit var traitsAdapter: RecyclerTraitsAdapter


    private var _binding: FragmentDetalhesHousesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDetalhesHousesBinding.inflate(inflater, container, false)

        pegaHouseSelecionada()

        populaCampos()

        return binding.root
    }

    private fun populaCampos() {
        viewModel.selectedHouse.observe(requireActivity()) { house ->
            binding.tvHouseName.text = house.name
            binding.tvAnimal.text = getString(R.string.animal_details).plus(house.animal)
            binding.tvFounderDescription.text = house.founder
            binding.tvColoursDescription.text = house.houseColours
            binding.tvElementDescription.text = house.element
            binding.tvGhostDescription.text = house.ghost
            binding.tvCommonRoomDescription.text = house.commonRoom

            configuraHeadsRecyclerView(house)

            configuraTraitsRecyclerView(house)
        }
    }

    private fun configuraTraitsRecyclerView(house: Houses) {
        binding.rvTraits.layoutManager = GridLayoutManager(context, 2)
        traitsAdapter = RecyclerTraitsAdapter(house.traits)
        binding.rvTraits.adapter = traitsAdapter
    }

    private fun configuraHeadsRecyclerView(house: Houses) {
        binding.rvHeads.layoutManager = GridLayoutManager(context, 2)
        headsAdapter = RecyclerHeadsAdapter(house.heads)
        binding.rvHeads.adapter = headsAdapter
    }

    private fun pegaHouseSelecionada() {
        requireActivity().intent.getStringExtra("houseId")
            ?.let { viewModel.pegaHouseSelecionada(it) }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}