package br.com.hp_app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.hp_app.data.model.Heads
import br.com.hp_app.databinding.DetailsRecyclerviewItemBinding

class RecyclerHeadsAdapter(private val heads: List<Heads>) :
    Adapter<RecyclerHeadsAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: DetailsRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(heads: Heads) {
            binding.rvItemName.text = heads.firstName.plus(" ").plus(heads.lastName)
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
        holder.bind(heads[position])
    }

    override fun getItemCount(): Int {
        return heads.size
    }

}