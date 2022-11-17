package br.com.hp_app.ui.wizards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import br.com.hp_app.data.model.Wizards
import br.com.hp_app.databinding.FragmentWizardDetailsBinding
import br.com.hp_app.ui.adapters.RecyclerWizardElixirsAdapter
import br.com.hp_app.ui.viewmodel.DetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class WizardDetailsFragment : Fragment() {

    private val viewModel by viewModel<DetailsViewModel>()

    private var _binding: FragmentWizardDetailsBinding? = null

    private lateinit var elixirsAdapter: RecyclerWizardElixirsAdapter


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentWizardDetailsBinding.inflate(inflater, container, false)

        getSelectedSpell()

        populateFields()

        return binding.root
    }

    private fun populateFields() {
        viewModel.selectedWizard.observe(requireActivity()) { wizard ->
            if (wizard.firstName != null) {
                binding.tvName.text = wizard.firstName.plus(" ".plus(wizard.lastName))
            } else {
                binding.tvName.text = wizard.lastName
            }
            setupElixirsRecyclerView(wizard)
        }
    }

    private fun getSelectedSpell() {
        requireActivity().intent.getStringExtra("wizardId")
            ?.let { viewModel.getSelectedWizard(it) }
    }

    private fun setupElixirsRecyclerView(wizards: Wizards) {
        binding.rvElixirs.layoutManager = GridLayoutManager(context, 2)
        setElixirsAdapter(wizards)
    }

    private fun setElixirsAdapter(wizards: Wizards) {
        elixirsAdapter = RecyclerWizardElixirsAdapter(wizards.elixirs)
        binding.rvElixirs.adapter = elixirsAdapter
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}