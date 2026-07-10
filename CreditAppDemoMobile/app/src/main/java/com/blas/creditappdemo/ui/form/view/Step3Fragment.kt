package com.blas.creditappdemo.ui.form.view

import android.os.*
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.blas.creditappdemo.R
import com.blas.creditappdemo.databinding.FragmentStep3Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Step3Fragment : Fragment() {

    private var _binding: FragmentStep3Binding? = null
    private val binding get() = _binding!!

    private val handler = Handler(Looper.getMainLooper())

    private val runnable = Runnable {
        if (isAdded) {
            findNavController().navigate(R.id.action_step3_to_step4)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentStep3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        handler.postDelayed(runnable, 3000)
    }

    override fun onDestroyView() {
        handler.removeCallbacks(runnable)
        _binding = null
        super.onDestroyView()
    }
}