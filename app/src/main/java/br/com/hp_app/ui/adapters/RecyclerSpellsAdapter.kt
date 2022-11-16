package br.com.hp_app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.hp_app.databinding.ListasRecyclerviewItemBinding
import br.com.hp_app.data.model.Spells

class RecyclerSpellsAdapter(private val spells: List<Spells>) :
    RecyclerView.Adapter<RecyclerSpellsAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ListasRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun vincula(spells: Spells) = with(binding) {
            tvNome.text = spells.name
            tvDescricao.text = spells.effect
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListasRecyclerviewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.vincula(spells[position])
    }

    override fun getItemCount(): Int {
        return spells.size
    }
}