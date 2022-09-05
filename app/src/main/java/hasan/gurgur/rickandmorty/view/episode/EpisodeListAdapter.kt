package hasan.gurgur.rickandmorty.view.episode

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hasan.gurgur.rickandmorty.BaseListAdapter
import hasan.gurgur.rickandmorty.model.episode.EpisodeModel

class EpisodeListAdapter (
    private val characterClickCallback: ((EpisodeModel?) -> Unit)?
) : BaseListAdapter<EpisodeModel>(
    itemsSame = { old, new -> old.id == new.id },
    contentsSame = { old, new -> old == new }
) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is EpisodeItemHolder -> {
                holder.bind(
                    episode = getItem(position),
                    characterClickCallback = characterClickCallback
                )
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return EpisodeItemHolder(parent, inflater)
    }

}