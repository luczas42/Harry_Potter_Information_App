package br.com.hp_app.ui.wizards

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.hp_app.data.model.Wizards
import br.com.hp_app.databinding.FragmentWizardsBinding
import br.com.hp_app.ui.DetailsActivity
import br.com.hp_app.ui.adapters.RecyclerWizardsAdapter
import br.com.hp_app.ui.viewmodel.ListsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WizardsFragment : Fragment() {

    private var _binding: FragmentWizardsBinding? = null
    private val viewModel by viewModel<ListsViewModel>()
    private lateinit var adapter: RecyclerWizardsAdapter


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentWizardsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupRecyclerView()

        return root
    }

    private fun setupRecyclerView() {
        viewModel.getWizardList()
        viewModel.wizardList.observe(requireActivity()) { wizards ->
            binding.recyclerViewWizards.layoutManager = LinearLayoutManager(context)
            setAdapter(wizards)
            setItemClickListener()
            onAdapterSuccess()
        }
    }

    private fun onAdapterSuccess() {
        if (adapter.itemCount > 0) {
            binding.recyclerViewWizards.visibility = View.VISIBLE
            binding.loading.visibility = View.GONE
        }
    }

    private fun setItemClickListener() {
        adapter.itemClickListener = { wizardId ->
            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra("wizardId", wizardId)
            startActivity(intent)
        }
    }

    private fun setAdapter(wizards: List<Wizards>) {
        adapter = RecyclerWizardsAdapter(wizards)
        binding.recyclerViewWizards.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.wizardList.removeObservers(requireActivity())

        _binding = null
    }

}