package hasan.gurgur.rickandmorty.view.character

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import hasan.gurgur.rickandmorty.R
import hasan.gurgur.rickandmorty.databinding.FragmentCharactersBinding
import hasan.gurgur.rickandmorty.viewmodel.CharacterListViewModel


class CharactersFragment : Fragment() {


    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CharacterListViewModel
    lateinit var characterListAdapter: CharacterListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        initAdapter()

        viewModel = ViewModelProvider(requireActivity()).get(CharacterListViewModel::class.java)
        viewModel.fetchDataFromRemoteApi()


        viewModel.characters.observe(requireActivity()) {
            characterListAdapter.submitList(it.results)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initAdapter() {
        characterListAdapter = CharacterListAdapter {
          findNavController().navigate(R.id.action_charactersFragment_to_detailFragment, bundleOf("model" to it))
        }

        binding.characterRec.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.characterRec.adapter = characterListAdapter
    }

}