package com.todak.playground.ui.expandtext

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.todak.playground.R
import com.todak.playground.databinding.FragmentExpandTextBinding
import com.todak.playground.databinding.FragmentStartBinding

class ExpandTextFragment : Fragment() {

    private var binding: FragmentExpandTextBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentExpandTextBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }
}