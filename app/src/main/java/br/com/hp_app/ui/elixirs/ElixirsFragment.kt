package br.com.hp_app.ui.elixirs

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.hp_app.data.model.Elixirs
import br.com.hp_app.databinding.FragmentElixirsBinding
import br.com.hp_app.ui.DetailsActivity
import br.com.hp_app.ui.adapters.RecyclerElixirsAdapter
import br.com.hp_app.ui.viewmodel.ListsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ElixirsFragment : Fragment() {

    private var _binding: FragmentElixirsBinding? = null

    private val viewModel by viewModel<ListsViewModel>()

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

        setupRecyclerView()

        return root
    }

    private fun setupRecyclerView() {
        viewModel.getElixirList()
        viewModel.elixirList.observe(requireActivity()) { elixirs ->
            binding.recyclerViewElixirs.layoutManager = LinearLayoutManager(context)
            setAdapter(elixirs)
            setItemClickListener()
        }
    }

    private fun setItemClickListener() {
        adapter.itemClickListener = { elixirId ->
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("elixirId", elixirId)
            startActivity(intent)
        }
    }

    private fun setAdapter(elixirs: List<Elixirs>) {
        adapter = RecyclerElixirsAdapter(elixirs)
        binding.recyclerViewElixirs.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.elixirList.removeObservers(requireActivity())

        _binding = null
    }
}