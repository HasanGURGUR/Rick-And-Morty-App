package hasan.gurgur.rickandmorty.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hasan.gurgur.rickandmorty.BaseListAdapter
import hasan.gurgur.rickandmorty.model.Result

class CharacterListAdapter (
    private val characterClickCallback: ((Result?) -> Unit)?
) : BaseListAdapter<Result>(
    itemsSame = { old, new -> old.id == new.id },
    contentsSame = { old, new -> old == new }
) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CharacterItemHolder -> {
                holder.bind(
                    character = getItem(position),
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
        return CharacterItemHolder(parent, inflater)
    }

}