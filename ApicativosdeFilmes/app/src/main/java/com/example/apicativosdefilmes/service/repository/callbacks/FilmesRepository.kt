package com.example.apicativosdefilmes.service.repository.callbacks

import com.example.apicativosdefilmes.service.listeners.RequisicaoApi
import com.example.apicativosdefilmes.service.model.FilmesHome
import com.example.apicativosdefilmes.service.model.InfoFilmeEspecifico
import com.example.apicativosdefilmes.service.model.InfoFilmes
import com.example.apicativosdefilmes.service.model.retornojson.FilmesJson
import com.example.apicativosdefilmes.service.repository.endpoints.Filmes
import com.example.apicativosdefilmes.service.repository.retrofit.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmesRepository {
    private  val mRetrofit = Retrofit.createService(Filmes::class.java)

    fun filmesOriginaisNetflix(listener:RequisicaoApi<FilmesJson>){
        val call:Call<FilmesJson> = mRetrofit.originaiNetiflix()
        call.enqueue(object : Callback<FilmesJson> {
            override fun onResponse(
                call: Call<FilmesJson>,
                response: Response<FilmesJson>
            ) {
               if (response.code() == 200){
                   response.body()?.let { listener.onSucess(it) }
               }
            }

            override fun onFailure(call: Call<FilmesJson>, t: Throwable) {
                listener.onFailure(t.message.toString())
            }

        })
    }
    fun filmesRecomendados(listener:RequisicaoApi<FilmesJson>){
        val call:Call<FilmesJson> = mRetrofit.recomendados()
        call.enqueue(object : Callback<FilmesJson> {
            override fun onResponse(
                call: Call<FilmesJson>,
                response: Response<FilmesJson>
            ) {
               if (response.code() == 200){
                   response.body()?.let { listener.onSucess(it) }
               }
            }

            override fun onFailure(call: Call<FilmesJson>, t: Throwable) {
                listener.onFailure(t.message.toString())
            }

        })
    }
    fun filmesEmAlta(listener:RequisicaoApi<FilmesJson>){
        val call:Call<FilmesJson> = mRetrofit.emAlta()
        call.enqueue(object : Callback<FilmesJson> {
            override fun onResponse(
                call: Call<FilmesJson>,
                response: Response<FilmesJson>
            ) {
               if (response.code() == 200){
                   response.body()?.let { listener.onSucess(it) }
               }
            }

            override fun onFailure(call: Call<FilmesJson>, t: Throwable) {
                listener.onFailure(t.message.toString())
            }

        })
    }
    fun filmesAcao(listener:RequisicaoApi<FilmesJson>){
        val call:Call<FilmesJson> = mRetrofit.acao()
        call.enqueue(object : Callback<FilmesJson> {
            override fun onResponse(
                call: Call<FilmesJson>,
                response: Response<FilmesJson>
            ) {
               if (response.code() == 200){
                   response.body()?.let { listener.onSucess(it) }
               }
            }

            override fun onFailure(call: Call<FilmesJson>, t: Throwable) {
                listener.onFailure(t.message.toString())
            }

        })
    }
    fun filmesComedia(listener:RequisicaoApi<FilmesJson>){
        val call:Call<FilmesJson> = mRetrofit.comedia()
        call.enqueue(object : Callback<FilmesJson> {
            override fun onResponse(
                call: Call<FilmesJson>,
                response: Response<FilmesJson>
            ) {
               if (response.code() == 200){
                   response.body()?.let { listener.onSucess(it) }
               }
            }

            override fun onFailure(call: Call<FilmesJson>, t: Throwable) {
                listener.onFailure(t.message.toString())
            }

        })
    }
    fun filmesTerror(listener:RequisicaoApi<FilmesJson>){
        val call:Call<FilmesJson> = mRetrofit.terror()
        call.enqueue(object : Callback<FilmesJson> {
            override fun onResponse(
                call: Call<FilmesJson>,
                response: Response<FilmesJson>
            ) {
               if (response.code() == 200){
                   response.body()?.let { listener.onSucess(it) }
               }
            }

            override fun onFailure(call: Call<FilmesJson>, t: Throwable) {
                listener.onFailure(t.message.toString())
            }

        })
    }
    fun filmesRomance(listener:RequisicaoApi<FilmesJson>){
        val call:Call<FilmesJson> = mRetrofit.romance()
        call.enqueue(object : Callback<FilmesJson> {
            override fun onResponse(
                call: Call<FilmesJson>,
                response: Response<FilmesJson>
            ) {
               if (response.code() == 200){
                   response.body()?.let { listener.onSucess(it) }
               }
            }

            override fun onFailure(call: Call<FilmesJson>, t: Throwable) {
                listener.onFailure(t.message.toString())
            }

        })
    }
    fun filmesDocumentarios(listener:RequisicaoApi<FilmesJson>){
        val call:Call<FilmesJson> = mRetrofit.documentarios()
        call.enqueue(object : Callback<FilmesJson> {
            override fun onResponse(
                call: Call<FilmesJson>,
                response: Response<FilmesJson>
            ) {
               if (response.code() == 200){
                   response.body()?.let { listener.onSucess(it) }
               }
            }

            override fun onFailure(call: Call<FilmesJson>, t: Throwable) {
                listener.onFailure(t.message.toString())
            }

        })
    }
    fun filmesSimilares(idFilme:Long,listener:RequisicaoApi<FilmesJson>){
        val call:Call<FilmesJson> = mRetrofit.filmesSimilares(idFilme)
        call.enqueue(object : Callback<FilmesJson> {
            override fun onResponse(
                call: Call<FilmesJson>,
                response: Response<FilmesJson>
            ) {
               if (response.code() == 200){
                   response.body()?.let { listener.onSucess(it) }
               }
            }

            override fun onFailure(call: Call<FilmesJson>, t: Throwable) {
                listener.onFailure(t.message.toString())
            }

        })
    }

    fun infoFilme(idFilme:Long,listener:RequisicaoApi<InfoFilmeEspecifico>){
        val call:Call<InfoFilmeEspecifico> = mRetrofit.infoFilmeEspecifico(idFilme)
        call.enqueue(object : Callback<InfoFilmeEspecifico> {
            override fun onResponse(
                call: Call<InfoFilmeEspecifico>,
                response: Response<InfoFilmeEspecifico>
            ) {
                if (response.code() == 200){
                    response.body()?.let { listener.onSucess(it) }
                }
            }

            override fun onFailure(call: Call<InfoFilmeEspecifico>, t: Throwable) {
                listener.onFailure(t.message.toString())
            }

        })
    }
}