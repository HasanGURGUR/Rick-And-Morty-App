package hasan.gurgur.rickandmorty.view.episode

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import hasan.gurgur.rickandmorty.databinding.FragmentEpisodesBinding
import hasan.gurgur.rickandmorty.viewmodel.CharacterListViewModel


class EpisodesFragment : Fragment() {

    private var _binding: FragmentEpisodesBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CharacterListViewModel
    lateinit var episodesListAdapter: EpisodeListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(requireActivity()).get(CharacterListViewModel::class.java)
        viewModel.fetchEpisodesDataFromRemoteApi()
        _binding = FragmentEpisodesBinding.inflate(inflater, container, false)
        initAdapter()

        viewModel.episodes.observe(requireActivity()) {
            episodesListAdapter.submitList(it.results)
        }

        return binding.root
    }

    private fun initAdapter() {
        episodesListAdapter = EpisodeListAdapter {
            Toast.makeText(requireContext(), it?.name, Toast.LENGTH_SHORT).show()
        }

        binding.episodeRec.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.episodeRec.adapter = episodesListAdapter
    }
}