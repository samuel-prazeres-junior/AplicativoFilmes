package com.example.apicativosdefilmes.service.model.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apicativosdefilmes.R
import com.example.apicativosdefilmes.service.constants.Constants
import com.example.apicativosdefilmes.service.listeners.EventOnclickListener
import com.example.apicativosdefilmes.service.model.InfoFilmes
import com.squareup.picasso.Picasso

class OriginaisNetflixAdapter(val filmesOriginais: List<InfoFilmes>, val onclick: EventOnclickListener<InfoFilmes>) :
    RecyclerView.Adapter<OriginaisNetflixAdapter.OriginaisViewHolder>() {

    class OriginaisViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
            fun render(filme: InfoFilmes, onclick: EventOnclickListener<InfoFilmes>){
                val imgFilme:ImageView = view.findViewById(R.id.iv_filme)
                Picasso.get().load("${Constants.URL.IMAGE_BASE}${filme.poster_path}").into(imgFilme)
                view.setOnClickListener {
                    onclick.onclickListener(filme)
                }

            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OriginaisViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return OriginaisViewHolder(layoutInflater.inflate(R.layout.filmes, parent, false))
    }

    override fun onBindViewHolder(holder: OriginaisViewHolder, position: Int) {
        holder.render(filmesOriginais[position],onclick)
    }

    override fun getItemCount(): Int = filmesOriginais.size
}