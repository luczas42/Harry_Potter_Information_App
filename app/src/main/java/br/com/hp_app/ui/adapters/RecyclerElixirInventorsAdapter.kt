package br.com.hp_app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.hp_app.databinding.DetalhesRecyclerviewItemBinding
import br.com.hp_app.data.model.Heads
import br.com.hp_app.data.model.Ingredients
import br.com.hp_app.data.model.Inventors
import br.com.hp_app.data.model.Wizards

class RecyclerElixirInventorsAdapter(private val inventors: List<Inventors>) :
    Adapter<RecyclerElixirInventorsAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: DetalhesRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun vincula(inventor: Inventors) {
            if (inventor.firstName !=null){
                binding.rvItemName.text = inventor.firstName.plus(" ".plus(inventor.lastName))
            }else{
                binding.rvItemName.text = inventor.lastName
            }
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
        holder.vincula(inventors[position])
    }

    override fun getItemCount(): Int {
        return inventors.size
    }

}