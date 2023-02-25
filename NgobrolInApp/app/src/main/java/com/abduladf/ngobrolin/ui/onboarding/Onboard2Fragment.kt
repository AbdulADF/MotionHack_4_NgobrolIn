package com.abduladf.ngobrolin.ui.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abduladf.ngobrolin.R
import com.abduladf.ngobrolin.databinding.FragmentOnboard2Binding
import com.abduladf.ngobrolin.ui.login.LoginRegisterActivity

class Onboard2Fragment : Fragment() {

    private var _binding: FragmentOnboard2Binding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboard2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOnboard2Binding.bind(view)
        binding.btnGetStarted.setOnClickListener {
            startActivity(Intent(requireContext(), LoginRegisterActivity::class.java))
        }
    }

}