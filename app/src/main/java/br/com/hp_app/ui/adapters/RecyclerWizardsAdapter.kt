package br.com.hp_app.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.hp_app.data.model.Wizards
import br.com.hp_app.databinding.ListsRecyclerviewItemBinding

class RecyclerWizardsAdapter(private var wizards: List<Wizards>) :
    RecyclerView.Adapter<RecyclerWizardsAdapter.ViewHolder>() {

    lateinit var itemClickListener: (String) -> Unit


    inner class ViewHolder(private val binding: ListsRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(wizards: Wizards) = with(binding) {
            wizardNameNullCheck(wizards)
            tvDescricao.visibility = View.GONE
            viewDivider.visibility = View.INVISIBLE
            itemView.rootView.setOnClickListener {
                itemClickListener.invoke(wizards.id)
            }
        }

        private fun wizardNameNullCheck(wizards: Wizards) {
            if (wizards.firstName != null) {
                binding.tvNome.text = wizards.firstName.plus(" ".plus(wizards.lastName))
            } else {
                binding.tvNome.text = wizards.lastName
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListsRecyclerviewItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(wizards[position])
    }

    override fun getItemCount(): Int {
        return wizards.size
    }


    fun filterItems(query: String) {
        val filteredList = ArrayList<Wizards>()
        wizards.forEach { wizard ->
            if (wizard.firstName != null) {
                if (wizard.firstName.plus(wizard.lastName).lowercase().trim()
                        .contains(query, true)
                ) {
                    filteredList.add(wizard)
                }
            } else {
                if (wizard.lastName.lowercase().trim().contains(query, true)) {
                    filteredList.add(wizard)
                }
            }
        }
        wizards = filteredList
        notifyDataSetChanged()
    }

    fun onFilterCleared(allWizards: List<Wizards>?) {
        if (allWizards != null) {
            wizards = allWizards
            notifyDataSetChanged()
        }
    }
}