package br.com.hp_app.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.hp_app.databinding.ListasRecyclerviewItemBinding
import br.com.hp_app.data.model.Ingredients

class RecyclerIngredientsAdapter(private val ingredients: List<Ingredients>) :
    RecyclerView.Adapter<RecyclerIngredientsAdapter.ViewHolder>() {

    lateinit var itemClickListener: (String) -> Unit

    inner class ViewHolder(private val binding: ListasRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun vincula(ingredients: Ingredients) = with(binding) {
            tvNome.text = ingredients.name
            tvDescricao.visibility = View.GONE
            viewDivider.visibility = View.INVISIBLE

            itemView.rootView.setOnClickListener {
                itemClickListener.invoke(ingredients.id)
            }
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
        holder.vincula(ingredients[position])
    }

    override fun getItemCount(): Int {
        return ingredients.size
    }
}