package com.blas.creditappdemo.ui.form.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.blas.creditappdemo.R
import com.blas.creditappdemo.databinding.FragmentStep2Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Step2Fragment : Fragment() {

    private var _binding: FragmentStep2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStep2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Tombol Lanjut ke Scoring Otomatis (Step 3)
        binding.btnNextStep.setOnClickListener {
            findNavController().navigate(R.id.action_step2_to_step3)
        }

        // Tombol Kembali ke Formulir (Step 1)
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Mencegah memory leak saat fragment dihancurkan sementara
        _binding = null
    }
}