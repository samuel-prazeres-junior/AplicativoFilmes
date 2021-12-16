package com.example.apicativosdefilmes.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apicativosdefilmes.R
import com.example.apicativosdefilmes.service.constants.Constants
import com.example.apicativosdefilmes.service.listeners.EventOnclickListener
import com.example.apicativosdefilmes.service.model.InfoFilmes
import com.example.apicativosdefilmes.service.model.adapters.OriginaisNetflixAdapter
import com.example.apicativosdefilmes.service.repository.callbacks.FilmesRepository
import com.example.apicativosdefilmes.viewmodel.FilmesViewModel
import com.squareup.picasso.Picasso
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var mRepository:  FilmesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        darkMode()
        buscarInfoApi()
        inicializarObservers()
    }

    fun darkMode(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        delegate.applyDayNight()
    }
    fun buscarInfoApi(){
        mRepository =  FilmesViewModel()
        mRepository.originaisNetflix()
        mRepository.filmesRecomendados()
        mRepository.filmesEmAlta()
        mRepository.filmesAcao()
        mRepository.filmesComedia()
        mRepository.filmesTerror()
        mRepository.filmesRomance()
        mRepository.filmesDocumentarios()
    }
    fun inicializarObservers(){
        observerOriginais()
        observerRecomendados()
        observerEmAlta()
        observerAcao()
        observerComedia()
        observerTerror()
        observerRomance()
        observerDocumentarios()
    }

    fun atribuirValoresPoster(filme:InfoFilmes){
        val imagemPoster:ImageView = findViewById(R.id.iv_poster_home)
        val tvNomeFilme:TextView = findViewById(R.id.tv_nome_filme_poster_home)
        Picasso.get().load("${Constants.URL.IMAGE_BASE}${filme.backdrop_path}").into(imagemPoster)
        tvNomeFilme.text = filme.title
    }
    fun observerOriginais(){
        mRepository.originais.observe(this, {
            if (it != null){
                inicioRecycler(it,findViewById(R.id.rv_originais_netflix))
            }
        })
    }
    fun observerRecomendados(){
        mRepository.recomendados.observe(this, {
            if (it != null){
                atribuirValoresPoster(it[Random.nextInt(0,it.size)])
                inicioRecycler(it,findViewById(R.id.rv_recomendados))
            }
        })
    }
    fun observerEmAlta(){
        mRepository.emAlta.observe(this, {
            if (it != null){
                inicioRecycler(it,findViewById(R.id.rv_em_alta))
            }
        })
    }
    fun observerAcao(){
        mRepository.acao.observe(this, {
            if (it != null){
                val recyclerView:RecyclerView = findViewById(R.id.rv_acao)
                inicioRecycler(it,recyclerView)
            }
        })
    }
    fun observerComedia(){
        mRepository.comedia.observe(this, {
            if (it != null){
                inicioRecycler(it,findViewById(R.id.rv_comedia))
            }
        })
    }
    fun observerTerror(){
        mRepository.terror.observe(this, {
            if (it != null){
                inicioRecycler(it,findViewById(R.id.rv_terror))
            }
        })
    }
    fun observerRomance(){
        mRepository.romance.observe(this, {
            if (it != null){
                inicioRecycler(it,findViewById(R.id.rv_romance))
            }
        })
    }
    fun observerDocumentarios(){
        mRepository.documentarios.observe(this, {
            if (it != null){
                inicioRecycler(it,findViewById(R.id.rv_documentarios))
            }
        })
    }

    fun inicioRecycler(filmes: List<InfoFilmes>, recyclerView:RecyclerView) {
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter = OriginaisNetflixAdapter(filmes, object : EventOnclickListener<InfoFilmes> {
            override fun onclickListener(filme: InfoFilmes) {
                val intent = Intent(this@MainActivity, FilmeEspecificoActivity::class.java)
                intent.putExtra("idFilme", filme.id)
                startActivity(intent)
            }
        })
        recyclerView.adapter = adapter
    }

}