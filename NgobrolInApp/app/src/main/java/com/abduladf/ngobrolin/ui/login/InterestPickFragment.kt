package com.abduladf.ngobrolin.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abduladf.ngobrolin.MainActivity
import com.abduladf.ngobrolin.R
import com.abduladf.ngobrolin.databinding.FragmentInterestPickBinding

class InterestPickFragment : Fragment() {

    private var _binding: FragmentInterestPickBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_interest_pick, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentInterestPickBinding.bind(view)
        binding.listBtNext.setOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }
    }

}