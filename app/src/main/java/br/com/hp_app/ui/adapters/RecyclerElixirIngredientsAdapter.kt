package br.com.hp_app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.hp_app.databinding.DetalhesRecyclerviewItemBinding
import br.com.hp_app.data.model.Heads
import br.com.hp_app.data.model.Ingredients

class RecyclerElixirIngredientsAdapter(private val ingredients: List<Ingredients>) :
    Adapter<RecyclerElixirIngredientsAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: DetalhesRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun vincula(ingredients: Ingredients) {
            binding.rvItemName.text = ingredients.name
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
        holder.vincula(ingredients[position])
    }

    override fun getItemCount(): Int {
        return ingredients.size
    }

}