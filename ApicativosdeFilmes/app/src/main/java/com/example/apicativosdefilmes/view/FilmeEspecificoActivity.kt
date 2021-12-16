package com.example.apicativosdefilmes.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apicativosdefilmes.R
import com.example.apicativosdefilmes.service.constants.Constants
import com.example.apicativosdefilmes.service.listeners.EventOnclickListener
import com.example.apicativosdefilmes.service.model.InfoFilmes
import com.example.apicativosdefilmes.service.model.adapters.OriginaisNetflixAdapter
import com.example.apicativosdefilmes.viewmodel.FilmesViewModel
import com.squareup.picasso.Picasso

class FilmeEspecificoActivity : AppCompatActivity() {
    private lateinit var filmesViewModel:FilmesViewModel
    private lateinit var imagemPoster:ImageView
    private lateinit var imagemFundo:ImageView
    private lateinit var tvNome:TextView
    private lateinit var tvNota:TextView
    private lateinit var tvDescricao:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filme_especifico)
        filmesViewModel = FilmesViewModel()
        val dados = intent.extras
        instanciarComponentes()
        observerSimilares()
        observerInfoFilme()
        if (dados != null) {
            val idFilme = dados.getInt("idFilme").toLong()
            filmesViewModel.infoFilme(idFilme)
        }

    }
    fun instanciarComponentes(){
        imagemPoster = findViewById(R.id.iv_poster_filme_especifico)
        imagemFundo = findViewById(R.id.iv_fundo_poster_filme_especifico)
        tvNome = findViewById(R.id.tv_nome_filme)
        tvNota = findViewById(R.id.tv_nota_filme)
        tvDescricao = findViewById(R.id.tv_descricao_filme)
    }

    fun inicioRecycler(filmes: List<InfoFilmes>, recyclerView: RecyclerView) {
        recyclerView.layoutManager = GridLayoutManager(this, 3) // deixando layout em grade 3 em cada linha
        val adapter = OriginaisNetflixAdapter(filmes, object : EventOnclickListener<InfoFilmes> {
            override fun onclickListener(filme: InfoFilmes) {
                filmesViewModel.filmesSimilares(filme.genre_ids[0].toLong())
                Picasso.get().load(filme.backdrop_path).into(imagemPoster)
            }
        })
        recyclerView.adapter = adapter
    }
    fun observerSimilares(){
        filmesViewModel.similares.observe(this, {
            if (it != null){
                inicioRecycler(it, findViewById(R.id.rv_info_filme_especifico))
            }
        })
    }

    fun observerInfoFilme(){
        filmesViewModel.infoFilme.observe(this, {
            Picasso.get().load("${Constants.URL.IMAGE_BASE}${it.backdrop_path}").into(imagemFundo)
            Picasso.get().load("${Constants.URL.IMAGE_BASE}${it.poster_path}").into(imagemPoster)
            tvNome.text = it.title
            tvNota.text = it.vote_average.toString()
            tvDescricao.text = it.overview
            filmesViewModel.filmesSimilares(it.genres[0].id.toLong())
        })
    }
}