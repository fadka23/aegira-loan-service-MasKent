package com.blas.creditappdemo.ui.form.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.blas.creditappdemo.R
import com.blas.creditappdemo.databinding.FragmentStep0Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Step0Fragment : Fragment() {

    private var _binding: FragmentStep0Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStep0Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Data list simulasi kendaraan
        val dataKendaraan = listOf("Kendaraan 1", "Kendaraan 2", "Kendaraan 3", "Kendaraan 4")

        // Mengonfigurasi RecyclerView
        binding.rvKendaraan.layoutManager = LinearLayoutManager(requireContext())
        binding.rvKendaraan.adapter = KendaraanAdapter(dataKendaraan)

        // Navigasi dari Step 0 ke Step 1 saat tombol diklik
        binding.btnNextStep.setOnClickListener {
            findNavController().navigate(R.id.action_step0_to_step1)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}