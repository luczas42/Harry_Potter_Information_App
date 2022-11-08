package br.com.hp_app.ui.wizards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.hp_app.databinding.FragmentWizardsBinding
import br.com.hp_app.ui.adapters.RecyclerWizardsAdapter
import br.com.hp_app.ui.viewmodel.ListasViewModel

class WizardsFragment : Fragment() {

    private var _binding: FragmentWizardsBinding? = null
    private var viewModel: ListasViewModel = ListasViewModel()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentWizardsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        configuraRecyclerView()

        return root
    }

    private fun configuraRecyclerView() {
        viewModel.pegaListaWizards()
        viewModel.listaWizards.observe(requireActivity()) { wizards ->
            binding.recyclerViewWizards.layoutManager = LinearLayoutManager(context)
            binding.recyclerViewWizards.adapter = RecyclerWizardsAdapter(wizards)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}