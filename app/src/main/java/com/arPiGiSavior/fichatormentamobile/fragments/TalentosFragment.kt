package com.arPiGiSavior.fichatormentamobile.fragments


import TalentosLifecycleObs
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.arPiGiSavior.fichatormentamobile.R
import com.arPiGiSavior.fichatormentamobile.adapters.TalentoItemAdapter
import com.arPiGiSavior.fichatormentamobile.databinding.FragmentTalentosBinding
import com.arPiGiSavior.fichatormentamobile.model.Talento
import com.arPiGiSavior.fichatormentamobile.viewModels.TalentoFragmentViewModel

/**
 * A simple [Fragment] subclass.
 */
class TalentosFragment : Fragment() {

    lateinit var binding: FragmentTalentosBinding
    lateinit var viewModel: TalentoFragmentViewModel

    private val talentos: MutableList<Talento> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        TalentosLifecycleObs(this.lifecycle)
        viewModel = ViewModelProvider(requireActivity()).get(TalentoFragmentViewModel::class.java)
        viewModel.liveDataTalentos.observe(this, Observer<MutableList<Talento>> {
            talentos.clear()
            talentos.addAll(it)
            binding.recyclerTalentoItem.adapter?.notifyDataSetChanged()
        })

        viewModel.getAllTalentos()

        binding = inflateView(inflater, container)
        return binding.root
    }

    private fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) =
        DataBindingUtil.inflate<FragmentTalentosBinding>(
            inflater,
            R.layout.fragment_talentos,
            container,
            false
        ).apply {
            this.recyclerTalentoItem.let {
                it.layoutManager = LinearLayoutManager(this@TalentosFragment.context)
                it.adapter = TalentoItemAdapter(talentos)
            }
        }


}
