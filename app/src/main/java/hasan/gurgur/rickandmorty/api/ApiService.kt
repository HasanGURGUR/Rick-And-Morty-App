package hasan.gurgur.rickandmorty.api

import hasan.gurgur.rickandmorty.model.ApiResponseModel
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {


    @GET("character")
    fun getCharacters() : Single<ApiResponseModel>
}