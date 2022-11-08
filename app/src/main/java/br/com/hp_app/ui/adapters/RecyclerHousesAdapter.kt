package br.com.hp_app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.hp_app.databinding.ListasRecyclerviewItemBinding
import br.com.hp_app.model.Houses


class RecyclerHousesAdapter(private val houses: List<Houses>) :
    Adapter<RecyclerHousesAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ListasRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun vincula(houses: Houses) = with(binding) {
            tvNome.text = houses.name
            tvDescricao.text = houses.animal
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
        holder.vincula(houses[position])
    }

    override fun getItemCount(): Int {
        return houses.size
    }
}