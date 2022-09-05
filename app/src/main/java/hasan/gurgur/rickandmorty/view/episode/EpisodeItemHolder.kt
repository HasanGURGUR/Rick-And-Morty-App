package hasan.gurgur.rickandmorty.view.episode

import android.view.LayoutInflater
import android.view.ViewGroup
import hasan.gurgur.rickandmorty.BaseViewHolder
import hasan.gurgur.rickandmorty.databinding.ItemEpisodeListLayoutBinding

import hasan.gurgur.rickandmorty.model.episode.EpisodeModel
import hasan.gurgur.rickandmorty.model.location.LocationItem

class EpisodeItemHolder (
    parent: ViewGroup,
    inflater: LayoutInflater
) : BaseViewHolder<ItemEpisodeListLayoutBinding>(
    binding = ItemEpisodeListLayoutBinding.inflate(inflater, parent, false)
) {

    fun bind(
        episode : EpisodeModel,
        characterClickCallback : ((EpisodeModel) -> Unit)? = null
    ) {
        with(binding) {
            binding.episode = episode
            binding.mainLayout.setOnClickListener{
                characterClickCallback?.invoke(episode)
            }
            executePendingBindings()
        }
    }


}
