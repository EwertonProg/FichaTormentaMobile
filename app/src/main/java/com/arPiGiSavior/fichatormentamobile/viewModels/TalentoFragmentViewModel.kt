package com.arPiGiSavior.fichatormentamobile.viewModels

import android.annotation.SuppressLint
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.apollographql.apollo.rx2.Rx2Apollo
import com.arPiGiSavior.fichatormentamobile.TalentosQuery
import com.arPiGiSavior.fichatormentamobile.connector.TalentoApiConnector
import com.arPiGiSavior.fichatormentamobile.fragments.TalentosFragmentDirections
import com.arPiGiSavior.fichatormentamobile.model.Talento
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class TalentoFragmentViewModel : ViewModel() {

    val liveDataTalentos: MutableLiveData<MutableList<Talento>> by lazy {
        MutableLiveData<MutableList<Talento>>().apply {
            this.value = ArrayList()
        }
    }

    @SuppressLint("CheckResult")
    fun getAllTalentos() {
        val apolloClient = TalentoApiConnector.setupConnection()
        val talentosQuery = TalentosQuery.builder().build()
        Rx2Apollo.from(apolloClient.query(talentosQuery)).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe {
                liveDataTalentos.value = it.data()?.talentos()?.parser() as MutableList<Talento>
            }

    }

    fun MutableList<TalentosQuery.Talento>.parser(): MutableList<Talento> {
        val returnList = ArrayList<Talento>()
        this.forEach {
            returnList.add(
                Talento(
                    id = it.id(),
                    nome = it.nome(),
                    preRequisito = it.preRequisito(),
                    beneficio = it.beneficio()
                )
            )
        }
        return returnList
    }

}
