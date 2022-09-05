package hasan.gurgur.rickandmorty.model.location

import hasan.gurgur.rickandmorty.model.İnfo

data class LocationResponseModel (
    val info: İnfo,
    val results: List<LocationItem>
        )