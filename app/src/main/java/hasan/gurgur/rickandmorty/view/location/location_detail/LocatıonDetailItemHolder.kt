package hasan.gurgur.rickandmorty.view.location.location_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import hasan.gurgur.rickandmorty.BaseViewHolder
import hasan.gurgur.rickandmorty.databinding.ItemLocationDetailListLayoutBinding



class LocatıonDetailItemHolder (
    parent: ViewGroup,
    inflater: LayoutInflater
) : BaseViewHolder<ItemLocationDetailListLayoutBinding>(
    binding = ItemLocationDetailListLayoutBinding.inflate(inflater, parent, false)
) {

    fun bind(
        location : String,
        characterClickCallback : ((String) -> Unit)? = null
    ) {
        with(binding) {
            binding.locationDetail = location
            binding.mainLayout.setOnClickListener{
                characterClickCallback?.invoke(location)
            }
            executePendingBindings()
        }
    }


}