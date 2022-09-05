package hasan.gurgur.rickandmorty.api

import hasan.gurgur.rickandmorty.model.ApiResponseModel
import hasan.gurgur.rickandmorty.model.episode.EpisodeModel
import hasan.gurgur.rickandmorty.model.episode.EpisodeResponse
import hasan.gurgur.rickandmorty.model.location.LocationResponseModel
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {


    @GET("character")
    fun getCharacters() : Single<ApiResponseModel>

    @GET("location")
    fun getLocations() : Single<LocationResponseModel>

    @GET("episode")
    fun getEpisodes() : Single<EpisodeResponse>
}