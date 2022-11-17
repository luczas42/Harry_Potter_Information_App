package br.com.hp_app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.hp_app.data.model.Spells
import br.com.hp_app.databinding.ListsRecyclerviewItemBinding

class RecyclerSpellsAdapter(private val spells: List<Spells>) :
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
}