package hasan.gurgur.rickandmorty.api

import hasan.gurgur.rickandmorty.model.ApiResponseModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CharacterInstance {

    private val BASE_URL ="https://rickandmortyapi.com/api/"

    private val api  = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(ApiService::class.java)

    fun getCharacters(): Single<ApiResponseModel>{
        return api.getCharacters()
    }
}