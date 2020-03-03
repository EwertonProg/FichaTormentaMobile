package com.arPiGiSavior.fichatormentamobile

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.arPiGiSavior.fichatormentamobile.databinding.FragmentBlankBinding
import java.util.*
import java.util.concurrent.TimeUnit


class BlankFragment : Fragment() {
    private val args: BlankFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentBlankBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_blank,container,false)
        binding.text.text = args.id.toString()

        val calendar = Calendar.getInstance()
        calendar.set(2020,2,4,23,45)

        object : CountDownTimer( calendar.time.time - Date().time , 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.text.text = Date(millisUntilFinished).toHhMmSsInString()
            }

            override fun onFinish() {}
        }.start()

        return binding.root
    }

    fun Date.toHhMmSsInString() = String.format(
        "%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(time),

        TimeUnit.MILLISECONDS.toMinutes(time) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(time)),

        TimeUnit.MILLISECONDS.toSeconds(time) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(time))
    )
}
