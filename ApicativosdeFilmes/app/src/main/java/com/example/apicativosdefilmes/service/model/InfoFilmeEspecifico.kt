package com.example.apicativosdefilmes.service.model

data class InfoFilmeEspecifico (
    val backdrop_path: String,
    val genres: List<Generos>,
    val homepage: String,
    val id: Int,
    val original_title:String,
    val title:String,
    val original_language: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val vote_average: Double,
    val vote_count: Int
        )