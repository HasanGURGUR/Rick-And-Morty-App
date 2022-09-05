package hasan.gurgur.rickandmorty.view.location.location_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hasan.gurgur.rickandmorty.BaseListAdapter
import hasan.gurgur.rickandmorty.model.location.LocationItem
import hasan.gurgur.rickandmorty.view.location.LocationItemHolder

class LocationDetailListAdapter (
    private val characterClickCallback: ((String?) -> Unit)?
) : BaseListAdapter<String>(
    itemsSame = { old, new -> old == new },
    contentsSame = { old, new -> old == new }
) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LocatıonDetailItemHolder -> {
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
        return LocatıonDetailItemHolder(parent, inflater)
    }

}