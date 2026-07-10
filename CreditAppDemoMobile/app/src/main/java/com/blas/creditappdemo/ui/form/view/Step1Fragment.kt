package com.blas.creditappdemo.ui.form.view

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.blas.creditappdemo.R
import com.blas.creditappdemo.databinding.FragmentStep1Binding
import com.blas.creditappdemo.ui.form.viewmodel.SharedFormViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Step1Fragment : Fragment() {

    private var _binding: FragmentStep1Binding? = null
    private val binding get() = _binding!!

    private val viewModel: SharedFormViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentStep1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnNext.setOnClickListener {
            viewModel.updateStep1(binding.etNama.text.toString())
            findNavController().navigate(R.id.action_step1_to_step2)
        }

        setupDropdown()
        setupRiwayatDropdown()

        binding.btnNext.setOnClickListener {
            val tujuan = binding.dropdownTujuan.text.toString()
            val nama = binding.etNama.text.toString()

            viewModel.updateStep1(nama)

            findNavController().navigate(R.id.action_step1_to_step2)
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun setupDropdown() {
        val listTujuan = listOf(
            "Pilih tujuan",   // sebagai hint pilihan awal
            "Modal Usaha",
            "Biaya Pendidikan",
            "Renovasi Rumah",
            "Biaya Kesehatan",
            "Lainnya"
        )

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            listTujuan
        )

        binding.dropdownTujuan.setAdapter(adapter)

        // default value (optional)
        binding.dropdownTujuan.setText(listTujuan[0], false)

        // klik langsung buka dropdown
        binding.dropdownTujuan.setOnClickListener {
            binding.dropdownTujuan.showDropDown()
        }
    }

    private fun setupRiwayatDropdown() {

        val listRiwayat = listOf(
            "Pilih riwayat",
            "Lancar",
            "Kadang Terlambat",
            "Sering Terlambat",
            "Tidak Pernah Membayar"
        )

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            listRiwayat
        )

        binding.dropdownRiwayat.setAdapter(adapter)

        binding.dropdownRiwayat.setText(listRiwayat[0], false)

        binding.dropdownRiwayat.setOnClickListener {
            binding.dropdownRiwayat.showDropDown()
        }
    }
}