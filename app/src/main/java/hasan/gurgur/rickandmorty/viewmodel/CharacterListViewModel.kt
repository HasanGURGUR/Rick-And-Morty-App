package hasan.gurgur.rickandmorty.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hasan.gurgur.rickandmorty.api.CharacterInstance
import hasan.gurgur.rickandmorty.model.ApiResponseModel
import hasan.gurgur.rickandmorty.model.episode.EpisodeModel
import hasan.gurgur.rickandmorty.model.episode.EpisodeResponse
import hasan.gurgur.rickandmorty.model.location.LocationResponseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class CharacterListViewModel : ViewModel(){

    val characters = MutableLiveData<ApiResponseModel>()
    val locations = MutableLiveData<LocationResponseModel>()
    val episodes = MutableLiveData<EpisodeResponse>()

    private val characterService: CharacterInstance = CharacterInstance()
    private val disposable: CompositeDisposable = CompositeDisposable()


    fun fetchDataFromRemoteApi() {
        disposable.add(
            characterService.getCharacters()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<ApiResponseModel>() {
                    override fun onSuccess(response: ApiResponseModel) {

                        characters.value = response
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }

    fun fetchLocationsDataFromRemoteApi() {
        disposable.add(
            characterService.getLocations()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<LocationResponseModel>() {
                    override fun onSuccess(response: LocationResponseModel) {

                        locations.value = response
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }


    fun fetchEpisodesDataFromRemoteApi() {
        disposable.add(
            characterService.getEpisodes()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<EpisodeResponse>() {
                    override fun onSuccess(response: EpisodeResponse) {

                        episodes.value = response
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }


}