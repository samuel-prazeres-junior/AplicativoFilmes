package com.example.apicativosdefilmes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apicativosdefilmes.service.listeners.RequisicaoApi
import com.example.apicativosdefilmes.service.model.InfoFilmeEspecifico
import com.example.apicativosdefilmes.service.model.InfoFilmes
import com.example.apicativosdefilmes.service.model.retornojson.FilmesJson
import com.example.apicativosdefilmes.service.repository.callbacks.FilmesRepository

class FilmesViewModel {
    private val filmesRepository:FilmesRepository = FilmesRepository()

    private val mOriginais = MutableLiveData<List<InfoFilmes>>()
    var originais:LiveData<List<InfoFilmes>> = mOriginais

    private val mRecomendados = MutableLiveData<List<InfoFilmes>>()
    var recomendados:LiveData<List<InfoFilmes>> = mRecomendados

    private val mEmAlta = MutableLiveData<List<InfoFilmes>>()
    var emAlta:LiveData<List<InfoFilmes>> = mEmAlta

    private val mAcao = MutableLiveData<List<InfoFilmes>>()
    var acao:LiveData<List<InfoFilmes>> = mAcao

    private val mComedia = MutableLiveData<List<InfoFilmes>>()
    var comedia:LiveData<List<InfoFilmes>> = mComedia

    private val mTerror = MutableLiveData<List<InfoFilmes>>()
    var terror:LiveData<List<InfoFilmes>> = mTerror

    private val mRomance = MutableLiveData<List<InfoFilmes>>()
    var romance:LiveData<List<InfoFilmes>> = mRomance

    private val mDocumnetarios = MutableLiveData<List<InfoFilmes>>()
    var documentarios:LiveData<List<InfoFilmes>> = mDocumnetarios

    private val mSimilares = MutableLiveData<List<InfoFilmes>>()
    var similares:LiveData<List<InfoFilmes>> = mSimilares

    private val mInfoFilme = MutableLiveData<InfoFilmeEspecifico>()
    var infoFilme:LiveData<InfoFilmeEspecifico> = mInfoFilme

    fun originaisNetflix(){
        filmesRepository.filmesOriginaisNetflix(object : RequisicaoApi<FilmesJson> {
            override fun onSucess(body: FilmesJson) {
                mOriginais.value = body.results
            }

            override fun onFailure(str: String) {
                mOriginais.value = null
            }


        })
    }
    fun filmesRecomendados(){
        filmesRepository.filmesRecomendados(object : RequisicaoApi<FilmesJson> {
            override fun onSucess(body: FilmesJson) {
                mRecomendados.value = body.results
            }

            override fun onFailure(str: String) {
                mRecomendados.value = null
            }


        })
    }
    fun filmesEmAlta(){
        filmesRepository.filmesEmAlta(object : RequisicaoApi<FilmesJson> {
            override fun onSucess(body: FilmesJson) {
                mEmAlta.value = body.results
            }

            override fun onFailure(str: String) {
                mEmAlta.value = null
            }


        })
    }
    fun filmesAcao(){
        filmesRepository.filmesAcao(object : RequisicaoApi<FilmesJson> {
            override fun onSucess(body: FilmesJson) {
                mAcao.value = body.results
            }

            override fun onFailure(str: String) {
                mAcao.value = null
            }


        })
    }
    fun filmesComedia(){
        filmesRepository.filmesComedia(object : RequisicaoApi<FilmesJson> {
            override fun onSucess(body: FilmesJson) {
                mComedia.value = body.results
            }

            override fun onFailure(str: String) {
                mComedia.value = null
            }


        })
    }
    fun filmesTerror(){
        filmesRepository.filmesTerror(object : RequisicaoApi<FilmesJson> {
            override fun onSucess(body: FilmesJson) {
                mTerror.value = body.results
            }

            override fun onFailure(str: String) {
                mTerror.value = null
            }


        })
    }
    fun filmesRomance(){
        filmesRepository.filmesRomance(object : RequisicaoApi<FilmesJson> {
            override fun onSucess(body: FilmesJson) {
                mRomance.value = body.results
            }

            override fun onFailure(str: String) {
                mRomance.value = null
            }


        })
    }
    fun filmesDocumentarios(){
        filmesRepository.filmesDocumentarios(object : RequisicaoApi<FilmesJson> {
            override fun onSucess(body: FilmesJson) {
                mDocumnetarios.value = body.results
            }

            override fun onFailure(str: String) {
                mDocumnetarios.value = null
            }


        })
    }
    fun filmesSimilares(idFilme:Long){
        filmesRepository.filmesSimilares(idFilme,object : RequisicaoApi<FilmesJson> {
            override fun onSucess(body: FilmesJson) {
                mSimilares.value = body.results
            }

            override fun onFailure(str: String) {
                mSimilares.value = null
            }


        })
    }
    fun infoFilme(idFilme:Long){
        filmesRepository.infoFilme(idFilme, object : RequisicaoApi<InfoFilmeEspecifico>{
            override fun onSucess(body: InfoFilmeEspecifico) {
                mInfoFilme.value = body
            }

            override fun onFailure(str: String) {
                mInfoFilme.value = null
            }

        })
    }
}