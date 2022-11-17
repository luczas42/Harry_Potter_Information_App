package br.com.hp_app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.hp_app.data.model.Ingredients
import br.com.hp_app.databinding.DetailsRecyclerviewItemBinding

class RecyclerElixirIngredientsAdapter(private val ingredients: List<Ingredients>) :
    Adapter<RecyclerElixirIngredientsAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: DetailsRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(ingredients: Ingredients) {
            binding.rvItemName.text = ingredients.name
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
        holder.bind(ingredients[position])
    }

    override fun getItemCount(): Int {
        return ingredients.size
    }

}