package br.com.hp_app.ui.spells

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.hp_app.databinding.FragmentSpellsBinding
import br.com.hp_app.ui.DetailsActivity
import br.com.hp_app.ui.adapters.RecyclerSpellsAdapter
import br.com.hp_app.ui.viewmodel.ListsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SpellsFragment : Fragment() {

    private var _binding: FragmentSpellsBinding? = null
    private val viewModel by viewModel<ListsViewModel>()
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
        viewModel.getSpellList()
        viewModel.spellList.observe(requireActivity()) { spells ->
            binding.recyclerViewSpells.layoutManager = LinearLayoutManager(context)
            adapter = RecyclerSpellsAdapter(spells)
            binding.recyclerViewSpells.adapter = adapter
            adapter.itemClickListener = { spellId ->
                val intent = Intent(activity, DetailsActivity::class.java)
                intent.putExtra("spellId", spellId)
                startActivity(intent)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.spellList.removeObservers(requireActivity())
        _binding = null
    }
}