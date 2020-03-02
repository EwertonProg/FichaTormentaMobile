package com.arPiGiSavior.fichatormentamobile.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.arPiGiSavior.fichatormentamobile.databinding.TalentoItemBinding
import com.arPiGiSavior.fichatormentamobile.fragments.TalentosFragmentDirections
import com.arPiGiSavior.fichatormentamobile.model.Talento

class TalentoItemAdapter(private val talentos: MutableList<Talento>) :
    RecyclerView.Adapter<TalentoItemAdapter.TalentoItemHolder>() {

    inner class TalentoItemHolder(val binding: TalentoItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TalentoItemHolder(
        TalentoItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount() = talentos.size

    override fun onBindViewHolder(holder: TalentoItemHolder, position: Int) {
        holder.binding.talento = talentos[position]
        holder.binding.btnViewTalento.setOnClickListener {
            holder.binding.root.findNavController()
                .navigate(TalentosFragmentDirections.toFragmentBlankNavigation(talentos[position].id))
        }
    }
}