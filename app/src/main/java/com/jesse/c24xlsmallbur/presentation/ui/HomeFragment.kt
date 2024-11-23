package com.jesse.c24xlsmallbur.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jesse.c24xlsmallbur.R
import com.jesse.c24xlsmallbur.data.model.SmallResponseItem
import com.jesse.c24xlsmallbur.databinding.FragmentDetailBinding
import com.jesse.c24xlsmallbur.databinding.FragmentHomeBinding
import com.jesse.c24xlsmallbur.presentation.SmallViewModel
import com.jesse.c24xlsmallbur.presentation.adapter.SmallAdapter
import com.jesse.c24xlsmallbur.presentation.uistate.UIState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewmodel: SmallViewModel by activityViewModels()

    private lateinit var adapter: SmallAdapter
    private var lista = mutableListOf<SmallResponseItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        initRV()
        viewmodel.uiState.observe(viewLifecycleOwner){
            when(it){
                is UIState.Error -> {
                    binding.pb.visibility = View.GONE
                    Toast.makeText(requireContext(), "${it.error}", Toast.LENGTH_SHORT).show()
                }
                UIState.Loading -> binding.pb.visibility = View.VISIBLE
                is UIState.Success -> {
                    binding.pb.visibility = View.GONE
                    lista.clear()
                    lista.addAll(it.mySuccessList)
                    adapter.notifyDataSetChanged()
                }
            }
        }
        return binding.root
    }

    private fun initRV() {
        adapter = SmallAdapter(lista){
            viewmodel.updateDetail(it)
            findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
        }
        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        binding.rv.adapter = adapter
    }
    override fun onStart() {
        super.onStart()
        viewmodel.getData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}