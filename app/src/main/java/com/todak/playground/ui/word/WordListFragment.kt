package com.todak.playground.ui.word

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.todak.playground.databinding.FragmentWordListBinding

class WordListFragment : Fragment() {
    private var _binding: FragmentWordListBinding? = null
    private val binding get() = _binding!!
    //lateinit로 표시하면 null을 허용하도록 만들지 않아도 됩니다.
    private lateinit var letterId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            letterId = it.getString(LETTER).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWordListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        val letterId = activity?.intent?.extras?.getString(LETTER).toString()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = WordAdapter(letterId, requireContext())
            addItemDecoration(
                DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            )
        }

//        binding.title = getString(R.string.detail_prefix) + " " + letterId
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }
}