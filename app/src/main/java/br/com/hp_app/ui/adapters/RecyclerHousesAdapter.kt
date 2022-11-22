package br.com.hp_app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.hp_app.R
import br.com.hp_app.data.model.Houses
import br.com.hp_app.databinding.ListsRecyclerviewHousesItemBinding
import br.com.hp_app.databinding.ListsRecyclerviewItemBinding


class RecyclerHousesAdapter(private var houses: List<Houses>) :
    Adapter<RecyclerHousesAdapter.ViewHolder>() {

    lateinit var itemClickListener: (String) -> Unit

    inner class ViewHolder(private val binding: ListsRecyclerviewHousesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(houses: Houses) = with(binding) {
            tvNome.text = houses.name
            tvDescricao.text = houses.animal
            itemView.rootView.setOnClickListener {
                itemClickListener.invoke(houses.id)
            }

            if (houses.name == "Gryffindor"){
                houseImage.setImageResource(R.drawable.gryffindor_image)
            }else if (houses.name == "Ravenclaw"){
                houseImage.setImageResource(R.drawable.ravenclaw_image)
            }else if (houses.name == "Hufflepuff"){
                houseImage.setImageResource(R.drawable.hufflepuff_image)
            }else{
                houseImage.setImageResource(R.drawable.slytherin_image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListsRecyclerviewHousesItemBinding.inflate(
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
        houses = filteredList
        notifyDataSetChanged()
    }

    fun onFilterCleared(allHouses: List<Houses>?){
        if (allHouses != null) {
            houses = allHouses
            notifyDataSetChanged()
        }
    }

}
