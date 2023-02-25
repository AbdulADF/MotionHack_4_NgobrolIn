package com.abduladf.ngobrolin.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.abduladf.ngobrolin.R
import com.abduladf.ngobrolin.databinding.FragmentAudiLoginBinding

/**
 * A simple [Fragment] subclass.
 * Use the [AudiLoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AudiLoginFragment : Fragment() {

    private var _binding: FragmentAudiLoginBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_audi_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAudiLoginBinding.bind(view)
        binding.signUp.setOnClickListener {
            findNavController().navigate(R.id.action_audiLoginFragment_to_audiRegisterFragment)
        }
    }

}