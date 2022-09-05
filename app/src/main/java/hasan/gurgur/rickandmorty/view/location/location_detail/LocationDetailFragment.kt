package hasan.gurgur.rickandmorty.view.location.location_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import hasan.gurgur.rickandmorty.R
import hasan.gurgur.rickandmorty.databinding.FragmentEpisodesBinding
import hasan.gurgur.rickandmorty.databinding.FragmentLocationDetailBinding
import hasan.gurgur.rickandmorty.view.location.LocationListAdapter


class LocationDetailFragment : Fragment() {
    private var _binding: FragmentLocationDetailBinding? = null
    private val binding get() = _binding!!

    lateinit var locationDetailAdapter: LocationDetailListAdapter

    val args: LocationDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLocationDetailBinding.inflate(inflater, container, false)

        initAdapter()
        val list = args.locationDetailModel?.residents
        locationDetailAdapter.submitList(list)

        return binding.root
    }

    private fun initAdapter() {
        locationDetailAdapter = LocationDetailListAdapter {
            Toast.makeText(requireContext(), "deneme", Toast.LENGTH_SHORT).show()
        }

        binding .locationDetailRec .layoutManager =
            GridLayoutManager(requireContext(),2)
        binding.locationDetailRec.adapter = locationDetailAdapter
    }
}