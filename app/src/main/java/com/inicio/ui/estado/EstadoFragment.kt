package com.inicio.ui.estado

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.inicio.R
//import com.inicio.adapter.EstadoAdapter
import com.inicio.databinding.FragmentEstadoBinding
import com.inicio.viewmodel.EstadoViewModel

class EstadoFragment : Fragment() {

    private lateinit var estadoViewModel: EstadoViewModel
    private var _binding: FragmentEstadoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        estadoViewModel = ViewModelProvider(this)[EstadoViewModel::class.java]
        _binding = FragmentEstadoBinding.inflate(inflater,container,false)


        binding.addEstadoButton.setOnClickListener{
            findNavController().navigate(R.id.action_nav_estado_to_addEstadoFragment)
        }

//        val estadoAdapter = EstadoAdapter()
        val reciclador = binding.reciclador

//        reciclador.adapter = estadoAdapter
        reciclador.layoutManager = LinearLayoutManager(requireContext())

        estadoViewModel = ViewModelProvider(this)[EstadoViewModel::class.java]

//        estadoViewModel.getAllData.observe(viewLifecycleOwner) {
//                estados -> estadoAdapter.setData(estados)
//        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}