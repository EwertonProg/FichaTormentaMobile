package com.arPiGiSavior.fichatormentamobile.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.arPiGiSavior.fichatormentamobile.R
import com.arPiGiSavior.fichatormentamobile.fragments.TalentosFragmentDirections

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun apagar(view: View){
        view.visibility = View.GONE
    }

    fun navigate(view: View){
        view.findNavController().navigate(TalentosFragmentDirections.toFragmentBlankNavigation(1))
    }

}
