package br.com.hp_app.ui.spells

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.hp_app.databinding.FragmentSpellDetailsBinding
import br.com.hp_app.ui.viewmodel.DetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class SpellDetailsFragment : Fragment() {

    private val viewModel by viewModel<DetailsViewModel>()

    private var _binding: FragmentSpellDetailsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSpellDetailsBinding.inflate(inflater, container, false)

        pegaSpellSelecionada()

        populaCampos()

        return binding.root
    }

    private fun populaCampos() {
        viewModel.selectedSpell.observe(requireActivity()) { spell ->
            binding.tvName.text = spell.name
            binding.tvLightDescription.text = spell.light
            binding.tvCanBeVerbalDescription.text =
                spell.canBeVerbal.toString().replaceFirstChar { char -> char.uppercase() }
            binding.tvIncantationescription.text = spell.incantation
            binding.tvEffectsDescription.text = spell.effect
            binding.tvTypeDescription.text = spell.type
            binding.tvCreatorDescription.text = spell.creator
        }
    }

    private fun pegaSpellSelecionada() {
        requireActivity().intent.getStringExtra("spellId")?.let { viewModel.getSelectedSpell(it) }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}