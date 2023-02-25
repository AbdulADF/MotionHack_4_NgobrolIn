package com.abduladf.ngobrolin.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abduladf.ngobrolin.R
import com.abduladf.ngobrolin.databinding.FragmentWalletBinding

class WalletFragment : Fragment() {

    private var _binding: FragmentWalletBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wallet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentWalletBinding.bind(view)
        binding.arrowleft.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

}