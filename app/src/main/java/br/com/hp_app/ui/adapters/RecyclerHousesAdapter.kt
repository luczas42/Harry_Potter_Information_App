package br.com.hp_app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.hp_app.data.model.Houses
import br.com.hp_app.databinding.ListsRecyclerviewItemBinding


class RecyclerHousesAdapter(private val houses: List<Houses>) :
    Adapter<RecyclerHousesAdapter.ViewHolder>() {

    lateinit var itemClickListener: (String) -> Unit

    inner class ViewHolder(private val binding: ListsRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(houses: Houses) = with(binding) {
            tvNome.text = houses.name
            tvDescricao.text = houses.animal
            itemView.rootView.setOnClickListener {
                itemClickListener.invoke(houses.id)
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
        holder.bind(houses[position])
    }

    override fun getItemCount(): Int {
        return houses.size
    }

    fun filterItems(query: String){
        val filteredList = ArrayList<Houses>()
        houses.forEach { house ->
            if (house.name.lowercase().trim().contains(query)) {
                filteredList.add(house)
            }
        }
    }

}
