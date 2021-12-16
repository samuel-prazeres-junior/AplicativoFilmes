package com.example.apicativosdefilmes.service.listeners

interface RequisicaoApi<T> {

    fun onSucess(body:T)
    fun onFailure(str:String)
}