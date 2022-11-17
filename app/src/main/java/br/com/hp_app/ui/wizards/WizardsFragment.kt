package br.com.hp_app.ui.wizards

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.hp_app.databinding.FragmentWizardsBinding
import br.com.hp_app.ui.DetalhesActivity
import br.com.hp_app.ui.adapters.RecyclerWizardsAdapter
import br.com.hp_app.ui.viewmodel.ListasViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WizardsFragment : Fragment() {

    private var _binding: FragmentWizardsBinding? = null
    private val viewModel by viewModel<ListasViewModel>()
    private lateinit var adapter: RecyclerWizardsAdapter


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
            adapter = RecyclerWizardsAdapter(wizards)
            binding.recyclerViewWizards.adapter = adapter
            adapter.itemClickListener = { wizardId ->
                val intent = Intent(activity, DetalhesActivity::class.java)
                intent.putExtra("wizardId", wizardId)
                startActivity(intent)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.listaWizards.removeObservers(requireActivity())

        _binding = null
    }

}