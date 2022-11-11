package br.com.hp_app.ui.elixirs

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.hp_app.databinding.FragmentElixirsBinding
import br.com.hp_app.ui.DetalhesActivity
import br.com.hp_app.ui.adapters.RecyclerElixirsAdapter
import br.com.hp_app.ui.viewmodel.ListasViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ElixirsFragment : Fragment() {

    private var _binding: FragmentElixirsBinding? = null

    private val viewModel by viewModel<ListasViewModel>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private lateinit var adapter: RecyclerElixirsAdapter
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentElixirsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        if (activity != null && isAdded) {

            configuraRecyclerView()

        }

        return root
    }

    private fun configuraRecyclerView() {
        viewModel.pegaListaElixirs()
        viewModel.listaElixirs.observe(requireActivity()) { elixirs ->
            binding.recyclerViewElixirs.layoutManager = LinearLayoutManager(context)
            adapter = RecyclerElixirsAdapter(elixirs)
            binding.recyclerViewElixirs.adapter = adapter
            adapter.itemClickListener = { elixirId ->
                val intent = Intent(activity, DetalhesActivity::class.java)
                intent.putExtra("elixirId", elixirId)
                startActivity(intent)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.listaElixirs.removeObservers(requireActivity())

        _binding = null
    }
}