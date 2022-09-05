package hasan.gurgur.rickandmorty.api

import hasan.gurgur.rickandmorty.model.ApiResponseModel
import hasan.gurgur.rickandmorty.model.episode.EpisodeModel
import hasan.gurgur.rickandmorty.model.episode.EpisodeResponse
import hasan.gurgur.rickandmorty.model.location.LocationResponseModel
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

    fun getLocations(): Single<LocationResponseModel>{
        return api.getLocations()
    }

    fun getEpisodes(): Single<EpisodeResponse>{
        return  api.getEpisodes()
    }
}