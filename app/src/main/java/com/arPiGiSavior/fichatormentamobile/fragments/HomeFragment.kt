package com.arPiGiSavior.fichatormentamobile.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.arPiGiSavior.fichatormentamobile.R
import com.arPiGiSavior.fichatormentamobile.databinding.FragmentHomeBinding
import com.arPiGiSavior.fichatormentamobile.databinding.FragmentHomeBindingImpl

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home, container, false
        )
        binding.ivTalento.setOnClickListener {
            findNavController().navigate(R.id.to_talentos)
        }
        return binding.root
    }

}

