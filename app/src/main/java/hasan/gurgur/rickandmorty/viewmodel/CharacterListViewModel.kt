package hasan.gurgur.rickandmorty.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hasan.gurgur.rickandmorty.api.CharacterInstance
import hasan.gurgur.rickandmorty.model.ApiResponseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class CharacterListViewModel : ViewModel(){

    val characters = MutableLiveData<ApiResponseModel>()

    private val characterService: CharacterInstance = CharacterInstance()
    private val disposable: CompositeDisposable = CompositeDisposable()


    fun fetchDataFromRemoteApi() {
        disposable.add(
            characterService.getCharacters()
                .subscribeOn(Schedulers.io())
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
}