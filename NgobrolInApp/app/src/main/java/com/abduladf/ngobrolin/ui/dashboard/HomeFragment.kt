package com.abduladf.ngobrolin.ui.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.abduladf.ngobrolin.R
import com.abduladf.ngobrolin.data.remote.DinotisApiService
import com.abduladf.ngobrolin.databinding.FragmentHomeBinding
import com.abduladf.ngobrolin.model.ApiResponseListCreators
import com.abduladf.ngobrolin.model.Creator
import com.abduladf.ngobrolin.ui.profile.ProfileActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.creators.observe(viewLifecycleOwner, Observer { creators ->
            val adapter = CreatorItemAdapter(creators)
            binding.recyclerView.adapter = adapter
        })
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.profile.setOnClickListener {
            println("click profile")
            startActivity(Intent(requireContext(), ProfileActivity::class.java))
        }
    }

}