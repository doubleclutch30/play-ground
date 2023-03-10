package com.todak.playground

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.todak.playground.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    var _binding: FragmentHomeBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnWord.setOnClickListener {
            val action =
                HomeFragmentDirections.actionHomeFragmentToLetterListFragment()
           view.findNavController().navigate(action)
        }
        binding.btnGame.setOnClickListener {
            val action =
                HomeFragmentDirections.actionHomeFragmentToGameFragment()
            view.findNavController().navigate(action)
        }
        binding.btnCupcake.setOnClickListener {
            val action =
                HomeFragmentDirections.actionHomeFragmentToStartFragment()
            view.findNavController().navigate(action)
        }
        binding.btnExpandTextLine.setOnClickListener {
            val action =
                HomeFragmentDirections.actionHomeFragmentToExpandTextFragment()
            view.findNavController().navigate(action)
        }
    }
}