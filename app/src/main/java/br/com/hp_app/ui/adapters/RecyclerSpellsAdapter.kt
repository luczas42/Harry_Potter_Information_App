package br.com.hp_app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.hp_app.data.model.Houses
import br.com.hp_app.data.model.Spells
import br.com.hp_app.databinding.ListsRecyclerviewItemBinding

class RecyclerSpellsAdapter(private var spells: List<Spells>) :
    RecyclerView.Adapter<RecyclerSpellsAdapter.ViewHolder>() {

    lateinit var itemClickListener: (String) -> Unit

    inner class ViewHolder(private val binding: ListsRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(spells: Spells) = with(binding) {
            tvNome.text = spells.name
            tvDescricao.text = spells.effect
            itemView.rootView.setOnClickListener {
                itemClickListener.invoke(spells.id)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListsRecyclerviewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(spells[position])
    }

    override fun getItemCount(): Int {
        return spells.size
    }

    fun filterItems(query: String){
        val filteredList = ArrayList<Spells>()
        spells.forEach { spell ->
            if (spell.name.lowercase().trim().contains(query)) {
                filteredList.add(spell)
            }
        }
        spells = filteredList
        notifyDataSetChanged()
    }

    fun onFilterCleared(allSpells: List<Spells>?){
        if (allSpells != null) {
            spells = allSpells
            notifyDataSetChanged()
        }
    }
}