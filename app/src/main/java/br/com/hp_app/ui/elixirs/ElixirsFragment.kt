package br.com.hp_app.ui.elixirs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.hp_app.databinding.FragmentElixirsBinding
import br.com.hp_app.ui.adapters.RecyclerElixirsAdapter
import br.com.hp_app.ui.viewmodel.ListasViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ElixirsFragment : Fragment() {

    private var _binding: FragmentElixirsBinding? = null
    private val viewModel by viewModel<ListasViewModel>()
    private lateinit var adapter: RecyclerElixirsAdapter


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentElixirsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configuraRecyclerView()

    }

    private fun configuraRecyclerView() {
        viewModel.pegaListaElixirs()
        viewModel.listaElixirs.observe(requireActivity()) { elixirs ->
            binding.recyclerViewElixirs.layoutManager = LinearLayoutManager(context)
            adapter = RecyclerElixirsAdapter(elixirs)
            binding.recyclerViewElixirs.adapter = RecyclerElixirsAdapter(elixirs)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}