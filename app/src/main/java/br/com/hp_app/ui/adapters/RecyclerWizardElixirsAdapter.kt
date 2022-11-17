package br.com.hp_app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.hp_app.data.model.Elixirs
import br.com.hp_app.databinding.DetalhesRecyclerviewItemBinding
import br.com.hp_app.data.model.Heads
import br.com.hp_app.data.model.Ingredients

class RecyclerWizardElixirsAdapter(private val elixirs: List<Elixirs>) :
    Adapter<RecyclerWizardElixirsAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: DetalhesRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun vincula(elixirs: Elixirs) {
            binding.rvItemName.text = elixirs.name
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
        holder.vincula(elixirs[position])
    }

    override fun getItemCount(): Int {
        return elixirs.size
    }

}