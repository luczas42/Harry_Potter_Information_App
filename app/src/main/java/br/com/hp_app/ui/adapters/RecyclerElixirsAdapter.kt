package br.com.hp_app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.hp_app.databinding.ListasRecyclerviewItemBinding
import br.com.hp_app.model.Elixirs

class RecyclerElixirsAdapter(private val elixirs: List<Elixirs>) :
    RecyclerView.Adapter<RecyclerElixirsAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ListasRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun vincula(elixirs: Elixirs) = with(binding) {
            tvNome.text = elixirs.name
            tvDescricao.text = elixirs.effect
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
        holder.vincula(elixirs[position])
    }

    override fun getItemCount(): Int {
        return elixirs.size
    }
}