package com.arPiGiSavior.fichatormentamobile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.arPiGiSavior.fichatormentamobile.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {
    private val args: BlankFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentBlankBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_blank,container,false)
        binding.text.text = args.id.toString()
        return binding.root
    }
}
