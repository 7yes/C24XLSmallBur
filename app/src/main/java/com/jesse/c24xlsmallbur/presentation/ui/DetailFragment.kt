package com.jesse.c24xlsmallbur.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.jesse.c24xlsmallbur.R
import com.jesse.c24xlsmallbur.core.load
import com.jesse.c24xlsmallbur.databinding.FragmentDetailBinding
import com.jesse.c24xlsmallbur.databinding.FragmentHomeBinding
import com.jesse.c24xlsmallbur.presentation.SmallViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val viewmodel: SmallViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val item = viewmodel.lastData

        item.value?.let {
            binding.img.load(it.image)
            binding.name.text = item.value?.name
            binding.first.text = item.value?.firstEpisode
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}