package com.example.apicativosdefilmes.service.model.retornojson

import com.example.apicativosdefilmes.service.model.InfoFilmes

data class FilmesJson(val page:Int, val results:List<InfoFilmes>, val total_pages:Int,
                      val total_results:Int)