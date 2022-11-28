package br.com.hp_app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.hp_app.data.model.Traits
import br.com.hp_app.databinding.DetailsRecyclerviewItemBinding

class RecyclerTraitsAdapter(private val traits: List<Traits>) :
    Adapter<RecyclerTraitsAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: DetailsRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(traits: Traits) {
            binding.rvItemName.text = traits.name
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DetailsRecyclerviewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(traits[position])
    }

    override fun getItemCount(): Int {
        return traits.size
    }

}