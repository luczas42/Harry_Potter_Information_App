package br.com.hp_app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.hp_app.data.model.Inventors
import br.com.hp_app.databinding.DetailsRecyclerviewItemBinding

class RecyclerElixirInventorsAdapter(private val inventors: List<Inventors>) :
    Adapter<RecyclerElixirInventorsAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: DetailsRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(inventor: Inventors) {
            wizardNameNullCheck(inventor)
        }

        private fun wizardNameNullCheck(inventor: Inventors) {
            @Suppress("SENSELESS_COMPARISON")
            if (inventor.firstName != null) {
                binding.rvItemName.text = inventor.firstName.plus(" ".plus(inventor.lastName))
            } else {
                binding.rvItemName.text = inventor.lastName
            }
        }

        fun bind() {
            with(binding) {
                "Unknown".also { rvItemName.text = it }
            }
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
        if (inventors.isEmpty()){
            holder.bind()
        }else{
            holder.bind(inventors[position])
        }
    }

    override fun getItemCount(): Int {
        return if (inventors.isEmpty()){
            1
        }else{
            inventors.size
        }
    }

}