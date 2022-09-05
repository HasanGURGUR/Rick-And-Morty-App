package hasan.gurgur.rickandmorty.view.character

import android.view.LayoutInflater
import android.view.ViewGroup
import hasan.gurgur.rickandmorty.BaseViewHolder
import hasan.gurgur.rickandmorty.databinding.ItemCharacterListLayoutBinding
import hasan.gurgur.rickandmorty.model.Result


class CharacterItemHolder (
    parent: ViewGroup,
    inflater: LayoutInflater
) : BaseViewHolder<ItemCharacterListLayoutBinding>(
    binding = ItemCharacterListLayoutBinding.inflate(inflater, parent, false)
) {

    fun bind(
        character : Result,
        characterClickCallback : ((Result) -> Unit)? = null
    ) {
        with(binding) {
            binding.character = character
            binding.mainLayout.setOnClickListener{
                characterClickCallback?.invoke(character)
            }
            executePendingBindings()
        }
    }


}
