package hasan.gurgur.rickandmorty.view.location

import android.view.LayoutInflater
import android.view.ViewGroup
import hasan.gurgur.rickandmorty.BaseViewHolder

import hasan.gurgur.rickandmorty.databinding.ItemLocationListLayoutBinding
import hasan.gurgur.rickandmorty.model.Result
import hasan.gurgur.rickandmorty.model.location.LocationItem

class LocationItemHolder (
    parent: ViewGroup,
    inflater: LayoutInflater
) : BaseViewHolder<ItemLocationListLayoutBinding>(
    binding = ItemLocationListLayoutBinding.inflate(inflater, parent, false)
) {

    fun bind(
        location : LocationItem,
        characterClickCallback : ((LocationItem) -> Unit)? = null
    ) {
        with(binding) {
            binding.location = location
            binding.mainLayout.setOnClickListener{
                characterClickCallback?.invoke(location)
            }
            executePendingBindings()
        }
    }


}
