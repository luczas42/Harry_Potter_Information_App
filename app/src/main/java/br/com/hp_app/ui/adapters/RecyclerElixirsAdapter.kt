package br.com.hp_app.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.hp_app.data.model.Elixirs
import br.com.hp_app.databinding.ListsRecyclerviewItemBinding

class RecyclerElixirsAdapter(private var elixirs: List<Elixirs>) :
    RecyclerView.Adapter<RecyclerElixirsAdapter.ViewHolder>() {

    lateinit var itemClickListener: (String) -> Unit

    inner class ViewHolder(private val binding: ListsRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(elixirs: Elixirs) = with(binding) {
            tvNome.text = elixirs.name
            tvDescricao.text = elixirs.effect
            itemView.rootView.setOnClickListener {
                itemClickListener.invoke(elixirs.id)
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
        holder.bind(elixirs[position])
    }

    override fun getItemCount(): Int {
        return elixirs.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun filterItems(query: String) {
        val filteredList = ArrayList<Elixirs>()
        elixirs.forEach { elixir ->
            if (elixir.name.lowercase().trim().contains(query)) {
                filteredList.add(elixir)
            }
        }
        elixirs = filteredList
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun onFilterCleared(allElixirs: List<Elixirs>?) {
        if (allElixirs != null) {
            elixirs = allElixirs
            notifyDataSetChanged()
        }
    }
}