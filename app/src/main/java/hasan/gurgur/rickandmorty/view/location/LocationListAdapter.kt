package hasan.gurgur.rickandmorty.view.location

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hasan.gurgur.rickandmorty.BaseListAdapter
import hasan.gurgur.rickandmorty.model.location.LocationItem

class LocationListAdapter (
    private val characterClickCallback: ((LocationItem?) -> Unit)?
) : BaseListAdapter<LocationItem>(
    itemsSame = { old, new -> old.id == new.id },
    contentsSame = { old, new -> old == new }
) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LocationItemHolder -> {
                holder.bind(
                    location = getItem(position),
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
        return LocationItemHolder(parent, inflater)
    }

}