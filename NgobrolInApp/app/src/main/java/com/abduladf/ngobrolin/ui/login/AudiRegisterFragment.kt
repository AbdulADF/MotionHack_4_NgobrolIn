package com.abduladf.ngobrolin.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.abduladf.ngobrolin.R
import com.abduladf.ngobrolin.databinding.FragmentAudiRegisterBinding

class AudiRegisterFragment : Fragment() {

    private var _binding: FragmentAudiRegisterBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_audi_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAudiRegisterBinding.bind(view)
        binding.loginButton.setOnClickListener {
            findNavController().navigate(R.id.action_audiRegisterFragment_to_interestPickFragment)
        }
    }

}