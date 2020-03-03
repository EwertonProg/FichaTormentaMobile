package com.arPiGiSavior.fichatormentamobile.viewModels

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.apollographql.apollo.rx2.Rx2Apollo
import com.arPiGiSavior.fichatormentamobile.TalentosQuery
import com.arPiGiSavior.fichatormentamobile.connector.TalentoApiConnector
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

    fun MutableList<TalentosQuery.Talento>.parser() = map{it.parser()}


    fun TalentosQuery.Talento.parser() = Talento(
        id = this.id(),
        nome = this.nome(),
        preRequisito = this.preRequisito(),
        beneficio = this.beneficio()
    )
}
