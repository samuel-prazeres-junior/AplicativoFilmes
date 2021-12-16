package com.example.apicativosdefilmes.service.repository.endpoints

import com.example.apicativosdefilmes.service.constants.Constants
import com.example.apicativosdefilmes.service.model.FilmesHome
import com.example.apicativosdefilmes.service.model.InfoFilmeEspecifico
import com.example.apicativosdefilmes.service.model.InfoFilmes
import com.example.apicativosdefilmes.service.model.retornojson.FilmesJson
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Filmes {
    @GET("discover/tv?with_network=213&language=pt-BR&api_key=${Constants.URL.API_KEY}")
    fun originaiNetiflix(): Call<FilmesJson>

    @GET("trending/all/week?language=pt-BR&api_key=${Constants.URL.API_KEY}")
    fun recomendados(): Call<FilmesJson>

    @GET("movie/top_rated?language=pt-BR&api_key=${Constants.URL.API_KEY}")
    fun emAlta(): Call<FilmesJson>

    @GET("discover/movie?with_genres=28&language=pt-BR&api_key=${Constants.URL.API_KEY}")
    fun acao(): Call<FilmesJson>

    @GET("discover/movie?with_genres=35&language=pt-BR&api_key=${Constants.URL.API_KEY}")
    fun comedia(): Call<FilmesJson>

    @GET("discover/movie?with_genres=27&language=pt-BR&api_key=${Constants.URL.API_KEY}")
    fun terror(): Call<FilmesJson>

    @GET("discover/movie?with_genres=10749&language=pt-BR&api_key=${Constants.URL.API_KEY}")
    fun romance(): Call<FilmesJson>

    @GET("discover/movie?with_genres=99&language=pt-BR&api_key=${Constants.URL.API_KEY}")
    fun documentarios(): Call<FilmesJson>
    @GET("movie/{idFilme}/similar?api_key=${Constants.URL.API_KEY}&language=pt-BR&page=1")
    fun filmesSimilares(@Path("idFilme") idFIlme:Long): Call<FilmesJson>

    @GET("movie/{idFilme}?api_key=${Constants.URL.API_KEY}&language=pt-BR")
    fun infoFilmeEspecifico(@Path("idFilme")idFilme:Long):Call<InfoFilmeEspecifico>

}