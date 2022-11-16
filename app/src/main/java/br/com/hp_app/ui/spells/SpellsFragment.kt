package br.com.hp_app.ui.spells

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.hp_app.databinding.FragmentSpellsBinding
import br.com.hp_app.ui.DetalhesActivity
import br.com.hp_app.ui.adapters.RecyclerHousesAdapter
import br.com.hp_app.ui.adapters.RecyclerSpellsAdapter
import br.com.hp_app.ui.viewmodel.ListasViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SpellsFragment : Fragment() {

    private var _binding: FragmentSpellsBinding? = null
    private val viewModel by viewModel<ListasViewModel>()
    private lateinit var adapter: RecyclerSpellsAdapter



    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentSpellsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        configuraRecyclerView()

        return root
    }

    private fun configuraRecyclerView() {
        viewModel.pegaListaSpells()
        viewModel.listaSpells.observe(requireActivity()) { spells ->
            binding.recyclerViewSpells.layoutManager = LinearLayoutManager(context)
            adapter = RecyclerSpellsAdapter(spells)
            binding.recyclerViewSpells.adapter = adapter
            adapter.itemClickListener = { spellId ->
                val intent = Intent(activity, DetalhesActivity::class.java)
                intent.putExtra("spellId", spellId)
                startActivity(intent)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.listaSpells.removeObservers(requireActivity())
        _binding = null
    }
}