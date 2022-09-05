package hasan.gurgur.rickandmorty.view.location

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import hasan.gurgur.rickandmorty.R
import hasan.gurgur.rickandmorty.databinding.FragmentLocationsBinding
import hasan.gurgur.rickandmorty.viewmodel.CharacterListViewModel


class LocationsFragment : Fragment() {

    private var _binding: FragmentLocationsBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CharacterListViewModel
    lateinit var locationListAdapter: LocationListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLocationsBinding.inflate(inflater, container, false)
        initAdapter()

        viewModel = ViewModelProvider(requireActivity()).get(CharacterListViewModel::class.java)
        viewModel.fetchLocationsDataFromRemoteApi()

        viewModel.locations.observe(requireActivity()) {
            locationListAdapter.submitList(it.results)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun initAdapter() {
        locationListAdapter = LocationListAdapter {
            findNavController().navigate(R.id.action_locationsFragment_to_locationDetailFragment, bundleOf("location_detail_model" to it))
        }

        binding.locationRec.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.locationRec.adapter = locationListAdapter
    }
}