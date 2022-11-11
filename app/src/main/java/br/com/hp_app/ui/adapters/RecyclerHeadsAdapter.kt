package br.com.hp_app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.hp_app.databinding.DetalhesRecyclerviewItemBinding
import br.com.hp_app.model.Heads

class RecyclerHeadsAdapter(private val heads: List<Heads>) :
    Adapter<RecyclerHeadsAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: DetalhesRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun vincula(heads: Heads) {
            binding.rvItemName.text = heads.firstName.plus(" ").plus(heads.lastName)
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DetalhesRecyclerviewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.vincula(heads[position])
    }

    override fun getItemCount(): Int {
        return heads.size
    }

}