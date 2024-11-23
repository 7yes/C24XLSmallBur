package com.jesse.c24xlsmallbur.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.jesse.c24xlsmallbur.R
import com.jesse.c24xlsmallbur.databinding.FragmentDetailBinding
import com.jesse.c24xlsmallbur.databinding.FragmentHomeBinding
import com.jesse.c24xlsmallbur.presentation.SmallViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewmodel: SmallViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
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