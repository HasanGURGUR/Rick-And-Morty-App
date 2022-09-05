package hasan.gurgur.rickandmorty.model.episode

import hasan.gurgur.rickandmorty.model.location.LocationItem
import hasan.gurgur.rickandmorty.model.İnfo

data class EpisodeResponse (
    val info: İnfo,
    val results: List<EpisodeModel>
)