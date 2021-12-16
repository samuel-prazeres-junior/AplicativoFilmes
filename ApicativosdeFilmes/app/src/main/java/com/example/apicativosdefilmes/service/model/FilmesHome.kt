package com.example.apicativosdefilmes.service.model

data class FilmesHome (
    var page:Int,
    var total_results:Int,
    var total_pages:Int,
    var results:List<InfoFilmes>
        )