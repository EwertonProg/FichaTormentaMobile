package com.arPiGiSavior.fichatormentamobile.model

data class Talento(
    var id: Int,
    var nome: String,
    var beneficio: String,
    var especial: String = "",
    var grupoTalento: GrupoTalento? = null,
    var origem: Origem? = null,
    var preRequisito: String?,
    var descricao: String = ""
)

data class GrupoTalento(var id: Int, var descricao: String, var nome: String)

data class Origem(var id: Int, var descricao: String, var nome: String)



