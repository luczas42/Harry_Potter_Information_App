package br.com.hp_app.ui.houses

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import br.com.hp_app.R
import br.com.hp_app.data.model.Houses
import br.com.hp_app.databinding.FragmentHouseDetailsBinding
import br.com.hp_app.ui.adapters.RecyclerHeadsAdapter
import br.com.hp_app.ui.adapters.RecyclerTraitsAdapter
import br.com.hp_app.ui.viewmodel.DetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HousesDetailsFragment : Fragment() {

    private val viewModel by viewModel<DetailsViewModel>()
    private lateinit var headsAdapter: RecyclerHeadsAdapter
    private lateinit var traitsAdapter: RecyclerTraitsAdapter


    private var _binding: FragmentHouseDetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHouseDetailsBinding.inflate(inflater, container, false)

        getSelectedHouse()

        populateFields()

        return binding.root
    }

    private fun populateFields() {
        viewModel.selectedHouse.observe(requireActivity()) { house ->
            if (house.name == "Gryffindor") {
                binding.selectedHouseImage.setImageResource(R.drawable.gryffindor_image)
            } else if (house.name == "Ravenclaw") {
                binding.selectedHouseImage.setImageResource(R.drawable.ravenclaw_image)
            } else if (house.name == "Hufflepuff") {
                binding.selectedHouseImage.setImageResource(R.drawable.hufflepuff_image)
            } else {
                binding.selectedHouseImage.setImageResource(R.drawable.slytherin_image)
            }

            binding.tvHouseName.text = house.name
            binding.tvAnimal.text = getString(R.string.animal_details).plus(house.animal)
            binding.tvFounderDescription.text = house.founder
            binding.tvColoursDescription.text = house.houseColours
            binding.tvElementDescription.text = house.element
            binding.tvGhostDescription.text = house.ghost
            binding.tvCommonRoomDescription.text = house.commonRoom

            setupHeadsRecyclerView(house)

            setupTraitsRecyclerView(house)
        }
    }

    private fun setupTraitsRecyclerView(house: Houses) {
        binding.rvTraits.layoutManager = GridLayoutManager(context, 2)
        setTraitsAdapter(house)
    }

    private fun setTraitsAdapter(house: Houses) {
        traitsAdapter = RecyclerTraitsAdapter(house.traits)
        binding.rvTraits.adapter = traitsAdapter
    }

    private fun setupHeadsRecyclerView(house: Houses) {
        binding.rvHeads.layoutManager = GridLayoutManager(context, 2)
        setHeadsAdapter(house)
    }

    private fun setHeadsAdapter(house: Houses) {
        headsAdapter = RecyclerHeadsAdapter(house.heads)
        binding.rvHeads.adapter = headsAdapter
    }

    private fun getSelectedHouse() {
        requireActivity().intent.getStringExtra("houseId")
            ?.let { viewModel.getSelectedHouse(it) }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}